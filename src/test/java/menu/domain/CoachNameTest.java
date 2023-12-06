package menu.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatCode;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CoachNameTest {
    @Test
    @DisplayName("코치이름은 2-4글자 한글로만 입력 가능하다.")
    void createCoachName() {
        assertThatThrownBy(() -> new CoachName("뭉"))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new CoachName("java"))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatCode(() -> new CoachName("뭉이"))
                .doesNotThrowAnyException();
    }
}