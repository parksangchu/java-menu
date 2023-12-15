package menu.domain;

import java.util.ArrayList;
import java.util.List;

public class IgnoredMenu {
    private final List<String> menus = new ArrayList<>();

    public void addMenu(String menu) {
        menus.add(menu);
    }

    public boolean has(String menu) {
        return menus.contains(menu);
    }
}
