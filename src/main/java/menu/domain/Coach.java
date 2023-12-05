package menu.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
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
        List<String> menus = filterMenus(categoryNumber);
        String menu = Randoms.shuffle(menus).get(0);
        recommendFood.addFood(menu);
    }

    private List<String> filterMenus(int categoryNumber) {
        MenuCategory menuCategory = Recommender.recommendMenuCategory(categoryNumber);
        List<String> menus = menuCategory.getMenus();
        return menus.stream()
                .filter(intolerantFood::isEdible)
                .filter(recommendFood::isUneaten)
                .collect(Collectors.toList());
    }

    public boolean isFullCategorySize(int categoryNumber) {
        return recommendFood.isFullCategorySize(categoryNumber);
    }

    public CoachName getCoachName() {
        return coachName;
    }

    public List<String> createMenus() {
        List<String> recommendResult = new ArrayList<>();
        recommendResult.add(coachName.getName());
        recommendResult.addAll(recommendFood.getFoods());
        return recommendResult;
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
