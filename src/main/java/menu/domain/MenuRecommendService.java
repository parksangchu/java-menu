package menu.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class MenuRecommendService {
    public static void recommendMenus(List<Coach> coaches, List<MenuCategory> menuCategories) {
        for (MenuCategory menuCategory : menuCategories) {
            coaches.forEach(coach -> recommendMenu(coach, menuCategory));
        }
    }

    private static void recommendMenu(Coach coach, MenuCategory menuCategory) {
        List<String> menus = menuCategory.getMenus();
        while (true) {
            String menu = Randoms.shuffle(menus).get(0);
            if (coach.isAcceptable(menu)) {
                coach.addRecommendedMenu(menu);
                return;
            }
        }
    }

    public static void createRecommendResult(List<Coach> coaches) {
        for (Coach coach : coaches) {
            RecommendResult recommendResult = coach.createRecommendResult();
            RecommendResultRepository.addRecommendResult(recommendResult);
        }
    }
}
