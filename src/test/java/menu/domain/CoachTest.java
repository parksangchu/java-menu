package menu.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.Test;

class CoachTest {
    @Test
    void name() {
        assertThatThrownBy(() -> new Coach("뭉이이이이"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.INVALID_NAME.getMessage());
        Coach coach = new Coach("뭉이");
    }
}