package menu.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CoachGroupTest {
    @Test
    @DisplayName("코치의 이름은 중복될 수 없다.")
    void createDuplacted() {
        Coach coach1 = new Coach(new CoachName("뭉이"));
        Coach coach2 = new Coach(new CoachName("뭉이"));
        assertThatThrownBy(() -> new CoachGroup(List.of(coach1, coach2)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 코치 이름은 중복될 수 없습니다.");
    }

    @Test
    @DisplayName("코치는 최소 2명에서 최대 5명이어야 한다.")
    void createInvalidSize() {
        Coach coach1 = new Coach(new CoachName("금실이"));
        Coach coach2 = new Coach(new CoachName("뭉이"));
        Coach coach3 = new Coach(new CoachName("루니"));
        Coach coach4 = new Coach(new CoachName("감자"));
        Coach coach5 = new Coach(new CoachName("풍경이"));
        Coach coach6 = new Coach(new CoachName("호피"));
        assertThatThrownBy(() -> new CoachGroup(List.of(coach1)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 코치는 최소 2명에서 최대5명까지 입력해야합니다.");
        assertThatThrownBy(() -> new CoachGroup(List.of(coach1, coach2, coach3, coach4, coach5, coach6)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 코치는 최소 2명에서 최대5명까지 입력해야합니다.");
    }
}