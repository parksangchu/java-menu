package menu.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

class CategoryRecommenderTest {

    @Test
    @RepeatedTest(100)
    @DisplayName("같은 메뉴 카테고리를 2번 초과하여 추천하지 않는다.")
    void recommendCategories() {
        List<MenuCategory> menuCategories = CategoryRecommender.recommendCategories();
        assertThat(Collections.frequency(menuCategories, MenuCategory.KOREAN)).isLessThanOrEqualTo(2);
        assertThat(Collections.frequency(menuCategories, MenuCategory.JAPANESE)).isLessThanOrEqualTo(2);
    }
}