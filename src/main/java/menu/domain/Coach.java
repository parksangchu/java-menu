package menu.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Coach {
    private final CoachName coachName;
    private ExcludedMenu excludedMenu;
    private final RecommendMenu recommendMenu;

    public Coach(CoachName coachName) {
        this.coachName = coachName;
        recommendMenu = new RecommendMenu();
    }

    public void initExcludedMenu(ExcludedMenu excludedMenu) {
        this.excludedMenu = excludedMenu;
    }

    public void pickMenu(MenuCategory menuCategory) {
        List<String> menus = filterMenus(menuCategory);
        String menu = Randoms.shuffle(menus).get(0);
        recommendMenu.add(menu);
    }

    private List<String> filterMenus(MenuCategory menuCategory) {
        List<String> menus = menuCategory.getMenus();
        return menus.stream()
                .filter(excludedMenu::isEdible)
                .filter(recommendMenu::isUneaten)
                .collect(Collectors.toList());
    }

    public boolean isFull(int categoryNumber) {
        return recommendMenu.isFull(categoryNumber);
    }

    public CoachName getCoachName() {
        return coachName;
    }

    public List<String> createRecommendResult() {
        List<String> recommendResult = new ArrayList<>();
        recommendResult.add(coachName.getName());
        recommendResult.addAll(recommendMenu.getMenus());
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
