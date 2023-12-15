package menu.domain;

public enum ErrorMessage {
    INVALID_MENU("유효하지 않은 메뉴입니다.");

    private static final String ERROR = "[ERROR] ";
    private final String message;

    ErrorMessage(String message) {
        this.message = ERROR + message;
    }

    public String getMessage() {
        return message;
    }
}
