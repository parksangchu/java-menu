package menu.domain;

import java.util.List;
import java.util.stream.Collectors;

public class CoachGroup {
    private static final int MIN_SIZE = 2;
    private static final int MAX_SIZE = 5;
    private static final String DUPLICATED_ERROR = "[ERROR] 코치 이름은 중복될 수 없습니다.";
    private static final String SIZE_ERROR = "[ERROR] 코치는 최소 2명에서 최대5명까지 입력해야합니다.";
    private final List<Coach> coaches;

    public CoachGroup(List<Coach> coaches) {
        validateDuplicated(coaches);
        validateSize(coaches);
        this.coaches = coaches;
    }

    private void validateDuplicated(List<Coach> coaches) {
        if (coaches.stream()
                .distinct()
                .count() != coaches.size()) {
            throw new IllegalArgumentException(DUPLICATED_ERROR);
        }
    }

    private void validateSize(List<Coach> coaches) {
        if (coaches.size() < MIN_SIZE || coaches.size() > MAX_SIZE) {
            throw new IllegalArgumentException(SIZE_ERROR);
        }
    }

    private List<String> pickMenus() {
        return coaches.stream()
                .map(Coach::pickMenu)
                .collect(Collectors.toList());
    }

    public List<Coach> getCoaches() {
        return coaches;
    }
}
