package menu.domain;

public class MenuCategoryRecommender {
    public static MenuCategory recommendMenuCategory(int randomNumber) {
        return MenuCategory.from(randomNumber);
    }
}
