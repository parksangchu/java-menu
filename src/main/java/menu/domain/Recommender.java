package menu.domain;

public class Recommender {
    public static MenuCategory recommendMenuCategory(int randomNumber) {
        return MenuCategory.from(randomNumber);
    }
}
