package menu.view;

import java.util.List;
import java.util.stream.Collectors;
import menu.domain.MenuCategory;
import menu.domain.RecommendResult;

public class OutputView {
    private static final String START_NOTICE = "점심 메뉴 추천을 시작합니다.";
    private static final String RESULT_NOTICE = "\n메뉴 추천 결과입니다.";
    private static final String DAY_OF_WEEK = "[ 구분 | 월요일 | 화요일 | 수요일 | 목요일 | 금요일 ]";
    private static final String CATEGORY_LABEL = "카테고리";
    private static final String PREFIX = "[ ";
    private static final String SUFFIX = " ]";
    private static final String DELIMITER = " | ";
    private static final String EXIT_NOTICE = "\n추천을 완료했습니다.";

    public static void printError(Exception e) {
        System.out.println(e.getMessage());
    }

    public static void printStartNotice() {
        System.out.println(START_NOTICE);
    }

    public static void printCategories(List<MenuCategory> menuCategories) {
        System.out.println(RESULT_NOTICE);
        System.out.println(DAY_OF_WEEK);
        List<String> categoryNames = menuCategories.stream()
                .map(MenuCategory::getName)
                .collect(Collectors.toList());
        categoryNames.add(0, CATEGORY_LABEL);
        System.out.println(StringOf(categoryNames));
    }

    private static String StringOf(List<String> list) {
        return list.stream()
                .collect(Collectors.joining(DELIMITER, PREFIX, SUFFIX));
    }

    public static void printRecommendResult(List<RecommendResult> recommendResults) {
        for (RecommendResult recommendResult : recommendResults) {
            List<String> result = recommendResult.getMenus();
            result.add(0, recommendResult.getName());
            System.out.println(StringOf(result));
        }
    }

    public static void printExitNotice() {
        System.out.println(EXIT_NOTICE);
    }
}
