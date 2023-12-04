package menu.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class NumberGenerator {
    private static final int MIN_NUMBER_LIMIT = 1;
    private static final int MAX_NUMBER_LIMIT = 5;

    public static int generateNumber() {
        return Randoms.pickNumberInRange(MIN_NUMBER_LIMIT, MAX_NUMBER_LIMIT);
    }
}
