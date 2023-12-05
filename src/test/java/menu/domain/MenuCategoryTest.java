package menu.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.Test;

class MenuCategoryTest {

    @Test
    void from() {
        MenuCategory menuCategory = MenuCategory.from("우동");
        assertThat(menuCategory.getCategoryName()).isEqualTo("일식");
    }
}