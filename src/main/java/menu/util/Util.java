package menu.util;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Util {
    public static List<String> splitByComma(String input) {
        return Arrays.stream(input.split(Regex.COMMA.regex))
                .map(String::trim)
                .collect(Collectors.toList());
    }

    private enum Regex {
        COMMA(",");

        private final String regex;

        Regex(String regex) {
            this.regex = regex;
        }
    }

    private Util() {
    }
}
