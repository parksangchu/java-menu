package menu.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Coach {
    private final CoachName coachName;
    private ExcludedMenu excludedMenu;
    private final RecommendedMenu recommendedMenu;

    public Coach(CoachName coachName) {
        this.coachName = coachName;
        recommendedMenu = new RecommendedMenu();
    }

    public void initExcludedMenu(ExcludedMenu excludedMenu) {
        this.excludedMenu = excludedMenu;
    }

    public void pickMenu(MenuCategory menuCategory) {
        List<String> menus = filterMenus(menuCategory);
        String menu = Randoms.shuffle(menus).get(0);
        recommendedMenu.add(menu);
    }

    private List<String> filterMenus(MenuCategory menuCategory) {
        List<String> menus = menuCategory.getMenus();
        return menus.stream()
                .filter(menu -> !excludedMenu.has(menu))
                .filter(menu -> !recommendedMenu.has(menu))
                .collect(Collectors.toList());
    }

    public boolean isFull(int categoryNumber) {
        return recommendedMenu.isFull(categoryNumber);
    }

    public CoachName getCoachName() {
        return coachName;
    }

    public List<String> createRecommendResult() {
        List<String> recommendResult = new ArrayList<>();
        recommendResult.add(coachName.getName());
        recommendResult.addAll(recommendedMenu.getMenus());
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
