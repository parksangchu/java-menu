package menu.view;

import java.util.List;

public class OutputView {
    private static final String START_NOTICE = "점심 메뉴 추천을 시작합니다.";
    private static final String ROW_FORMAT = "[ %s | %s | %s | %s | %s | %s ]";

    public static void printError(Exception e) {
        System.out.println(e.getMessage());
    }

    public static void printStartNotice() {
        System.out.println(START_NOTICE);
    }

    public static void printResult(List<List<String>> result) {
        System.out.printf(ROW_FORMAT, "구분", "월요일", "화요일", "수요일", "목요일", "금요일");
        for (int i = 0; i < result.size(); i++) {
            for (int j = 0; j < 5; j++) {
                List<String> row = result.get(i);
                System.out.printf(ROW_FORMAT
                        , row.get(0)
                        , row.get(1)
                        , row.get(2)
                        , row.get(3)
                        , row.get(4));
            }
            System.out.println();
        }
    }
}
