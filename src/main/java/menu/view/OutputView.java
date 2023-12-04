package menu.view;

public class OutputView {
    private static final String START_NOTICE = "점심 메뉴 추천을 시작합니다.";

    public static void printError(Exception e) {
        System.out.println(e.getMessage());
    }

    public static void printStartNotice() {
        System.out.println(START_NOTICE);
    }
}
