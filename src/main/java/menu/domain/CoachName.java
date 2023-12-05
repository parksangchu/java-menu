package menu.domain;

public class CoachName {
    private static final String TYPE_REGEX = "[가-힣]*";
    private static final int MIN_LENGTH = 2;
    private static final int MAX_LENGTH = 4;
    private static final String INVALID_TYPE_ERROR = "[ERROR] 코치 이름은 한글로만 입력 가능합니다.";
    private static final String INVALID_RANGE_ERROR = "[ERROR] 코치 이름은 최소 2글자, 최대 4글자입니다.";

    private final String name;

    public CoachName(String name) {
        validateType(name);
        validateRange(name);
        this.name = name;
    }

    private void validateType(String name) {
        if (!name.matches(TYPE_REGEX)) {
            throw new IllegalArgumentException(INVALID_TYPE_ERROR);
        }
    }

    private void validateRange(String name) {
        if (name.length() < MIN_LENGTH || name.length() > MAX_LENGTH) {
            throw new IllegalArgumentException(INVALID_RANGE_ERROR);
        }
    }

    public String getName() {
        return name;
    }
}
