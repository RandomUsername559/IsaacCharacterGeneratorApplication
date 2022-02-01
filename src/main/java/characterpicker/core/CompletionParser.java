package characterpicker.core;


import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

public class CompletionParser {
    private CompletionParser() {
        throw new IllegalArgumentException("Utility Class");
    }

    static List<String> parse(String completion) {
        return Arrays.stream(completion.split(","))
                .filter(CompletionParser::isEmpty)
                .map(CompletionParser::unifyCasing)
                .map(String::strip)
                .collect(Collectors.toList());
    }

    private static boolean isEmpty(String bossMark) {
        return bossMark.length() > 0;
    }

    private static String unifyCasing(String bossMark) {
        return bossMark.toLowerCase(Locale.ROOT);
    }
}
