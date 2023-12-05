package menu.view;

import java.util.List;

public class OutputView {
    private static final String START_NOTICE = "점심 메뉴 추천을 시작합니다.";
    private static final String CATEGORY_LINE = "카테고리";
    private static final String RESULT_NOTICE = "\n메뉴 추천 결과입니다.";
    private static final String RESULT_TITLE = "[ 구분 | 월요일 | 화요일 | 수요일 | 목요일 | 금요일 ]";
    private static final String LINE_FORMAT = "[ %s ]\n";
    private static final String DELIMITER = " | ";
    private static final String END_NOTICE = "\n추천을 완료했습니다.";

    public static void printError(Exception e) {
        System.out.println(e.getMessage());
    }

    public static void printStartNotice() {
        System.out.println(START_NOTICE);
    }


    public static void printResult(List<String> categories, List<List<String>> result) {
        System.out.println(RESULT_NOTICE);
        System.out.println(RESULT_TITLE);
        printCategories(categories);
        result.stream()
                .map(OutputView::convertToString)
                .forEach(line -> System.out.printf(LINE_FORMAT, line));
        System.out.println(END_NOTICE);
    }

    private static void printCategories(List<String> categories) {
        categories.add(0, CATEGORY_LINE);
        System.out.printf(LINE_FORMAT, convertToString(categories));
    }

    private static String convertToString(List<String> line) {
        return String.join(DELIMITER, line);
    }
}
