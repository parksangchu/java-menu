package menu.domain;

import java.util.List;

public class IntolerantFood {
    private static final String INVALID_MENU_NAME = "[ERROR] 존재하지 않는 메뉴 이름을 입력하셨습니다.";
    private final List<String> foods;

    public IntolerantFood(List<String> foods) {
        validateMenuName(foods);
        this.foods = foods;
    }

    private void validateMenuName(List<String> foods) {
        if (!foods.stream()
                .allMatch(MenuCategory::isValidFood)) {
            throw new IllegalArgumentException(INVALID_MENU_NAME);
        }
    }
}
