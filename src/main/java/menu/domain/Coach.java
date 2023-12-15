package menu.domain;

public class Coach {
    private static final int MIN_NAME_RANGE = 2;
    private static final int MAX_NAME_RANGE = 4;
    private final String name;
    private final IgnoredMenu ignoredMenu = new IgnoredMenu();
    private final RecommendedMenu recommendedMenu = new RecommendedMenu();

    public Coach(String name) {
        validateRange(name);
        this.name = name;
    }

    private void validateRange(String name) {
        if (name.length() < MIN_NAME_RANGE || name.length() > MAX_NAME_RANGE) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_NAME.getMessage());
        }
    }

    public void addIgnoredMenu(String menu) {
        ignoredMenu.addMenu(menu);
    }

    public void addRecommendedMenu(String menu) {
        recommendedMenu.addMenu(menu);
    }

    public String getName() {
        return name;
    }
}
