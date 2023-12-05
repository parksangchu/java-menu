package menu.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.Test;

class RecommenderTest {

    @Test
    void recommendMenuCategory() {
        MenuCategory menuCategory = Recommender.recommendMenuCategory(1);
        assertThat(menuCategory.getCategoryName()).isEqualTo("일식");
        menuCategory = Recommender.recommendMenuCategory(5);
        assertThat(menuCategory.getCategoryName()).isEqualTo("양식");
    }
}