package menu.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.Test;

class CoachGroupTest {
    @Test
    void create() {
        assertThatThrownBy(() -> new CoachGroup(List.of(new Coach("뭉이"))))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.INVALID_SIZE.getMessage());
    }
}