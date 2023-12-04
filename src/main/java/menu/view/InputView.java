package menu.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {
    private static final String ASK_COACH_NAME = "\n코치의 이름을 입력해 주세요. (, 로 구분)";
    private static final String DELIMITER = ",";

    public List<String> readName() {
        System.out.println(ASK_COACH_NAME);
        String input = Console.readLine();
        return divide(input);
    }

    private List<String> divide(String input) {
        return Arrays.stream(input.split(DELIMITER))
                .map(String::trim)
                .collect(Collectors.toList());
    }
}
