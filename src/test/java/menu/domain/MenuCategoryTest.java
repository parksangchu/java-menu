package menu.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class MenuCategoryTest {

    @ParameterizedTest
    @DisplayName("카테고리 번호에 따른 카테고리를 반환한다.")
    @CsvSource(value = {"1,일식", "2,한식", "3,중식", "4,아시안", "5,양식"})
    void from(int input, String expect) {
        MenuCategory menuCategory = MenuCategory.from(input);
        assertThat(menuCategory.getCategoryName()).isEqualTo(expect);
    }
}