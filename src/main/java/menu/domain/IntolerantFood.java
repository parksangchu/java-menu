package menu.domain;

import java.util.List;

public class IntolerantFood {
    private static final String INVALID_MENU_NAME = "[ERROR] 존재하지 않는 메뉴 이름을 입력하셨습니다.";
    private static final String INVALID_SIZE = "[ERROR] 못 먹는 음식은 최대 2개까지 입력 가능합니다.";
    private static final int MIN_SIZE = 0;
    private static final int MAX_SIZE = 2;
    private final List<String> foods;

    public IntolerantFood(List<String> foods) {
        validateSize(foods);
        validateMenuName(foods);
        this.foods = foods;
    }

    private void validateSize(List<String> foods) {
        if (foods.size() < MIN_SIZE || foods.size() > MAX_SIZE) {
            throw new IllegalArgumentException(INVALID_SIZE);
        }
    }

    private void validateMenuName(List<String> foods) {
        if (!foods.stream()
                .allMatch(MenuCategory::isValidFood)) {
            throw new IllegalArgumentException(INVALID_MENU_NAME);
        }
    }

    public boolean isIntolerantFood(String food) {
        return foods.contains(food);
    }

    public List<String> getFoods() {
        return foods;
    }
}
