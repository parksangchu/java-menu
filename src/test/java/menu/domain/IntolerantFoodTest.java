package menu.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatCode;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.Test;

class IntolerantFoodTest {
    @Test
    void createIntolerantFood() {
        List<String> foods1 = List.of("고기");
        assertThatThrownBy(() -> new IntolerantFood(foods1)).isInstanceOf(IllegalArgumentException.class);

        List<String> foods2 = List.of("");
        assertThatCode(() -> new IntolerantFood(foods2)).doesNotThrowAnyException();
    }
}