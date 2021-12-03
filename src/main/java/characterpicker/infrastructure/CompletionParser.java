package characterpicker.infrastructure;


import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

public class CompletionParser {
    private CompletionParser() {
        throw new IllegalArgumentException("Utility Class");
    }

    static Integer parseCompletion(String completion) {
        List<String> bosses = Arrays.stream(completion.split(","))
                .map(bossMark -> bossMark.toLowerCase(Locale.ROOT))
                .collect(Collectors.toList());
        return CompletionWeightCalculator.calculateCompletionWeight(bosses);

    }
}
