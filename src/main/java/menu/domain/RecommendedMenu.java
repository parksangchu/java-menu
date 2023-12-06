package menu.domain;

import java.util.ArrayList;
import java.util.List;

public class RecommendedMenu {
    private final List<String> menus = new ArrayList<>();

    public void add(String menu) {
        menus.add(menu);
    }

    public boolean has(String menu) {
        return menus.contains(menu);
    }

    public List<String> getMenus() {
        return menus;
    }
}
