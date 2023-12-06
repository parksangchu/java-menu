package menu.domain;

import java.util.ArrayList;
import java.util.List;

public class CategoryRecommender {
    private static final int DAYS_SIZE = 5;

    public static List<MenuCategory> recommendCategories(CoachGroup coachGroup) {
        List<MenuCategory> categories = new ArrayList<>();
        for (int i = 0; i < DAYS_SIZE; i++) {
            MenuCategory menuCategory = recommendCategory(coachGroup);
            categories.add(menuCategory);
        }
        return categories;
    }

    private static MenuCategory recommendCategory(CoachGroup coachGroup) {
        int randomNumber;
        do {
            randomNumber = NumberGenerator.generateNumber();
        } while (coachGroup.isFull(randomNumber));
        return MenuCategory.from(randomNumber);
    }
}
