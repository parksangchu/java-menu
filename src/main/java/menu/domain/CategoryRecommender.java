package menu.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CategoryRecommender {
    private static final int CATEGORY_CAPACITY = 2;
    private static final int DAYS_SIZE = 10;

    public static List<MenuCategory> recommendCategories() {
        List<MenuCategory> categories = new ArrayList<>();
        while (categories.size() != DAYS_SIZE) {
            MenuCategory menuCategory = recommendCategory();
            if (Collections.frequency(categories, menuCategory) != CATEGORY_CAPACITY) {
                categories.add(menuCategory);
            }
        }
        return categories;
    }

    private static MenuCategory recommendCategory() {
        int randomNumber = NumberGenerator.generateNumber();
        return MenuCategory.from(randomNumber);
    }
}
