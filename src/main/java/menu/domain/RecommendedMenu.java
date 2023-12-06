package menu.domain;

import java.util.ArrayList;
import java.util.List;

public class RecommendedMenu {
    private static final int CATEGORY_CAPACITY = 2;
    private final List<String> menus = new ArrayList<>();

    public void add(String menu) {
        menus.add(menu);
    }

    public boolean has(String menu) {
        return menus.contains(menu);
    }

    public boolean isFull(int number) {
        return menus.stream()
                .map(MenuCategory::from)
                .map(MenuCategory::getValue)
                .filter(categoryNumber -> categoryNumber == number)
                .count() == CATEGORY_CAPACITY;
    }

    public List<String> getMenus() {
        return menus;
    }
}
