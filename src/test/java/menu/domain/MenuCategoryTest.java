package menu.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.Test;

class MenuCategoryTest {

    @Test
    void findMenu() {
        assertThatThrownBy(() -> MenuCategory.findMenu("라볶이"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.INVALID_MENU.getMessage());
    }

    @Test
    void from() {
        assertThat(MenuCategory.from(1)).isEqualTo(MenuCategory.JAPANESE);
    }
}