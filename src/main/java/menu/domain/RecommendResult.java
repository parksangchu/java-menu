package menu.domain;

import java.util.List;

public class RecommendResult {
    private final String name;
    private final List<String> menus;

    public RecommendResult(String name, List<String> menus) {
        this.name = name;
        this.menus = menus;
    }

    public String getName() {
        return name;
    }

    public List<String> getMenus() {
        return menus;
    }
}
