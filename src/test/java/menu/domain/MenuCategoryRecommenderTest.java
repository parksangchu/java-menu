package menu.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.Test;

class MenuCategoryRecommenderTest {

    @Test
    void recommendMenuCategory() {
        MenuCategory menuCategory = MenuCategoryRecommender.recommendMenuCategory(1);
        assertThat(menuCategory.getCategoryName()).isEqualTo("일식");
        menuCategory = MenuCategoryRecommender.recommendMenuCategory(5);
        assertThat(menuCategory.getCategoryName()).isEqualTo("양식");
    }
}