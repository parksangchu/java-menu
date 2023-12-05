package menu.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class RecommendFood {
    private static final int FULL_CATEGORY_SIZE = 2;
    private final List<String> foods = new ArrayList<>();

    public void addFood(String food) {
        foods.add(food);
    }

    public boolean isUneaten(String menu) {
        return !foods.contains(menu);
    }

    public boolean isFullCategorySize(int number) {
        List<Integer> categoryNumbers = foods.stream()
                .map(MenuCategory::from)
                .map(MenuCategory::getValue)
                .collect(Collectors.toList());
        int categorySize = Collections.frequency(categoryNumbers, number);
        return categorySize == FULL_CATEGORY_SIZE;
    }

    public List<String> getFoods() {
        return foods;
    }
}
