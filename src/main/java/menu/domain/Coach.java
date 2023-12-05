package menu.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Coach {
    private final CoachName coachName;
    private IntolerantFood intolerantFood;
    private AlreadyEatenFood alreadyEatenFood;

    public Coach(CoachName coachName) {
        this.coachName = coachName;
    }

    public void initIntolerantFood(IntolerantFood intolerantFood) {
        this.intolerantFood = intolerantFood;
    }

    public String pickRecommendMenu() {
        List<String> menus = bringRecommendMenus();
        String menu = Randoms.shuffle(menus).get(0);
        return menu;
    }

    private List<String> bringRecommendMenus() {
        MenuCategory menuCategory = MenuCategoryRecommender.recommendMenuCategory(NumberGenerator.generateNumber());
        List<String> menus = menuCategory.getMenus();
        return menus.stream()
                .filter(menu -> !intolerantFood.getFoods()
                        .contains(menu))
                .collect(Collectors.toList());
    }

    public CoachName getCoachName() {
        return coachName;
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
