package menu.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {
    private static final String ASK_COACH_NAME = "\n코치의 이름을 입력해 주세요. (, 로 구분)";
    private static final String ASK_EXCLUDED_FOOD = "\n%s(이)가 못 먹는 메뉴를 입력해 주세요.\n";

    private static final String DELIMITER = ",";

    public static List<String> readName() {
        System.out.println(ASK_COACH_NAME);
        String input = Console.readLine();
        return divide(input);
    }

    private static List<String> divide(String input) {
        return Arrays.stream(input.split(DELIMITER))
                .map(String::trim)
                .collect(Collectors.toList());
    }

    public static List<String> readExcludedFood(String coachName) {
        System.out.printf(ASK_EXCLUDED_FOOD, coachName);
        String input = Console.readLine();
        return divide(input);
    }
}
