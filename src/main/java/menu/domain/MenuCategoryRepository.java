package menu.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MenuCategoryRepository {
    private static final int EACH_CAPACITY = 2;
    private static final int TOTAL_CAPACITY = 5;
    private static final List<MenuCategory> menuCategories = new ArrayList<>();

    public static List<MenuCategory> menuCategories() {
        return Collections.unmodifiableList(menuCategories);
    }

    public static void addMenuCategory(MenuCategory menuCategory) {
        if (Collections.frequency(menuCategories, menuCategory) < EACH_CAPACITY) {
            menuCategories.add(menuCategory);
        }
    }

    public static boolean isNotFull() {
        return menuCategories().size() < TOTAL_CAPACITY;
    }
}
