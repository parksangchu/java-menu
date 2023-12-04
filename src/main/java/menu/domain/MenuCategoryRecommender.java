package menu.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class MenuCategoryRecommender {
    public MenuCategory recommendMenuCategory() {
        int randomNumber = Randoms.pickNumberInRange(1, 5);
        return MenuCategory.from(randomNumber);
    }
}
