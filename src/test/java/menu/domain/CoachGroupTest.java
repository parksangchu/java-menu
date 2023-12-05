package menu.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.Test;

class CoachGroupTest {
    @Test
    void createCoachGroup() {
        Coach coach1 = new Coach(new CoachName("뭉이"));
        Coach coach2 = new Coach(new CoachName("뭉이"));
        assertThatThrownBy(() -> new CoachGroup(List.of(coach1, coach2))).isInstanceOf(IllegalArgumentException.class);
    }
}