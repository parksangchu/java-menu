package menu.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import menu.util.Util;

public class InputView {
    private static final String ASK_COACH_NAMES = "\n코치의 이름을 입력해 주세요. (, 로 구분)";

    public static List<String> readCoachNames() {
        System.out.println(ASK_COACH_NAMES);
        String input = Console.readLine();
        return Util.splitByComma(input);
    }
}
