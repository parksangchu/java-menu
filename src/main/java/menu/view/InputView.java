package menu.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import menu.util.Util;

public class InputView {
    private static final String ASK_COACH_NAMES = "\n코치의 이름을 입력해 주세요. (, 로 구분)";
    private static final String ASK_IGNORED_MENU_FORMAT = "\n%s(이)가 못 먹는 메뉴를 입력해 주세요.\n";

    public static List<String> readCoachNames() {
        System.out.println(ASK_COACH_NAMES);
        String input = Console.readLine();
        return Util.splitByComma(input);
    }

    public static List<String> readIgnoredMenu(String name) {
        System.out.printf(ASK_IGNORED_MENU_FORMAT, name);
        String input = Console.readLine();
        return Util.splitByComma(input);
    }
}
