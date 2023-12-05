package menu.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Coach {
    private final CoachName coachName;
    private IntolerantFood intolerantFood;
    private final RecommendFood recommendFood;

    public Coach(CoachName coachName) {
        this.coachName = coachName;
        recommendFood = new RecommendFood();
    }

    public void initIntolerantFood(IntolerantFood intolerantFood) {
        this.intolerantFood = intolerantFood;
    }


    public void pickMenu(int categoryNumber) {
        List<String> menus = bringRecommendMenus(categoryNumber);
        String menu = Randoms.shuffle(menus).get(0);
        recommendFood.addFood(menu);
    }

    private List<String> bringRecommendMenus(int categoryNumber) {
        MenuCategory menuCategory = MenuCategoryRecommender.recommendMenuCategory(categoryNumber);
        List<String> menus = menuCategory.getMenus();
        return menus.stream()
                .filter(menu -> !intolerantFood.isIntolerantFood(menu))
                .filter(menu -> !recommendFood.isAlreadyEating(menu))
                .collect(Collectors.toList());
    }

    public boolean isFullCategorySize(int categoryNumber) {
        return recommendFood.isFullCategorySize(categoryNumber);
    }

    public CoachName getCoachName() {
        return coachName;
    }

    public List<String> getRecommendFood() {
        return recommendFood.getFoods();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Coach)) {
            return false;
        }
        Coach coach = (Coach) o;
        return Objects.equals(coachName, coach.coachName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(coachName);
    }
}
