package menu.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class CategoryRecommender {
    private static final int MIN_NUMBER_RANGE = 1;
    private static final int MAX_NUMBER_RANGE = 5;

    public static void recommendCategories() {
        while (MenuCategoryRepository.isNotFull()) {
            int categoryNumber = generateCategoryNumber();
            MenuCategory menuCategory = MenuCategory.from(categoryNumber);
            MenuCategoryRepository.addMenuCategory(menuCategory);
        }
    }

    private static int generateCategoryNumber() {
        return Randoms.pickNumberInRange(MIN_NUMBER_RANGE, MAX_NUMBER_RANGE);
    }
}
