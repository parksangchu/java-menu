package menu.domain;

import java.util.List;

public class CoachGroup {
    private static final int MIN_COACHES_SIZE = 2;
    private static final int MAX_COACHES_SIZE = 5;
    private final List<Coach> coaches;

    public CoachGroup(List<Coach> coaches) {
        validateSize(coaches);
        this.coaches = coaches;
    }

    private void validateSize(List<Coach> coaches) {
        if (coaches.size() < MIN_COACHES_SIZE || coaches.size() > MAX_COACHES_SIZE) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_SIZE.getMessage());
        }
    }
}
