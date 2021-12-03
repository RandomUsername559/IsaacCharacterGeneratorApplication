package characterpicker.infrastructure;

import java.util.List;
import java.util.Map;

import static java.util.Map.entry;

public class CompletionWeightCalculator {

    private static final Map<String, Double> completionMarksWeights = Map.ofEntries(
            entry("mom's hearth", 0.1),
            entry("isaac", 0.1),
            entry("???", 0.1),
            entry("satan", 0.1),
            entry("the lamb", 0.1),
            entry("boss rush", 0.1),
            entry("ultra greed", 0.1),
            entry("hush", 0.25),
            entry("mega satan", 0.25),
            entry("delirium", 0.5),
            entry("mother", 0.5),
            entry("the beast", 0.5)
    );


    private CompletionWeightCalculator() {
        throw new IllegalStateException("Utility class");
    }

    static Integer calculate(List<String> list) {

        double sumOfWeights = 0;

        for (String boss : list) {
            if (!completionMarksWeights.containsKey(boss)) {
                continue;
            }
            sumOfWeights += completionMarksWeights.get(boss);

        }
        return (int) Math.round(sumOfWeights);
    }
}
