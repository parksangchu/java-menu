package menu.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatCode;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ExcludedMenuTest {
    @Test
    @DisplayName("메뉴판에 없는 메뉴를 입력하면 예외가 발생한다.")
    void createInvalidMenu() {
        List<String> foods1 = List.of("고기");
        assertThatThrownBy(() -> new ExcludedMenu(foods1))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("못먹는 메뉴에 공백을 입력할 수 있다.")
    void createEmptyMenu() {
        List<String> foods2 = List.of("");
        assertThatCode(() -> new ExcludedMenu(foods2)).doesNotThrowAnyException();
    }
}