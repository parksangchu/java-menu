package menu.domain;

import java.util.List;

public class ExcludedMenu {
    private static final String DUPLICATED = "[ERROR] 못 먹는 메뉴는 중복될 수 없습니다.";
    private static final String INVALID_MENU_NAME = "[ERROR] 존재하지 않는 메뉴 이름을 입력하셨습니다.";
    private static final String INVALID_SIZE = "[ERROR] 못 먹는 메뉴는 최대 2개까지 입력 가능합니다.";
    private static final int MAX_SIZE = 2;
    private final List<String> menus;

    public ExcludedMenu(List<String> menus) {
        validateDuplicated(menus);
        validateSize(menus);
        validateMenuName(menus);
        this.menus = menus;
    }

    private void validateDuplicated(List<String> menus) {
        if (menus.stream()
                .distinct()
                .count() != menus.size()) {
            throw new IllegalArgumentException(DUPLICATED);
        }
    }

    private void validateSize(List<String> menus) {
        if (menus.size() > MAX_SIZE) {
            throw new IllegalArgumentException(INVALID_SIZE);
        }
    }

    private void validateMenuName(List<String> menus) {
        if (!menus.stream()
                .allMatch(MenuCategory::has)) {
            throw new IllegalArgumentException(INVALID_MENU_NAME);
        }
    }

    public boolean has(String menu) {
        return menus.contains(menu);
    }
}
