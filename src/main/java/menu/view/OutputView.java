package menu.view;

import java.util.List;
import java.util.stream.Collectors;

public class OutputView {
    private static final String START_NOTICE = "점심 메뉴 추천을 시작합니다.";
    private static final String CATEGORY_TITLE = "카테고리";
    private static final String RESULT_NOTICE = "\n메뉴 추천 결과입니다.";
    private static final String DAYS_OF_WEEK_TITLE = "구분";
    private static final List<String> DAYS_OF_WEEK = List.of("월", "화", "수", "목", "금");
    private static final String DAY_OF_WEEK_UNIT = "요일";
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
        printDaysOfWeek();
        printCategories(categories);
        printMenus(result);
        System.out.println(END_NOTICE);
    }

    private static void printDaysOfWeek() {
        List<String> daysOfWeek = DAYS_OF_WEEK.stream()
                .map(dayOfWeek -> dayOfWeek + DAY_OF_WEEK_UNIT)
                .collect(Collectors.toList());
        daysOfWeek.add(0, DAYS_OF_WEEK_TITLE);
        System.out.printf(LINE_FORMAT, convertToString(daysOfWeek));
    }

    private static void printCategories(List<String> categories) {
        categories.add(0, CATEGORY_TITLE);
        System.out.printf(LINE_FORMAT, convertToString(categories));
    }

    private static void printMenus(List<List<String>> result) {
        result.stream()
                .map(OutputView::convertToString)
                .forEach(line -> System.out.printf(LINE_FORMAT, line));
    }

    private static String convertToString(List<String> line) {
        return String.join(DELIMITER, line);
    }
}
