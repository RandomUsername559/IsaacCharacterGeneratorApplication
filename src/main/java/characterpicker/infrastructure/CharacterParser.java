package characterpicker.infrastructure;

import characterpicker.domain.Character;
import characterpicker.domain.Weight;
import org.apache.commons.lang.StringUtils;

import java.util.List;

public class CharacterParser {

    private static final int NAME_INDEX = 0;
    private static final int WEIGHT_INDEX = 1;
    private static final String COMPLETION_MARK_SEPARATOR = "--c";
    private static final int CHARACTER_INDEX = 0;
    private static final int COMPLETION_INDEX = 1;
    private static final int DEFAULT_COMPLETION_WEIGHT = 0;
    private static final String CHARACTER_PROPERTIES_SEPARATOR = ",";

    private CharacterParser() {
        throw new IllegalStateException("Utility class");
    }

    static Character parseCharacter(String unparsedCharacterConfiguration) {

        String[] configurationGroups = unparsedCharacterConfiguration.split(COMPLETION_MARK_SEPARATOR);
        String unparsedCharacter = configurationGroups[CHARACTER_INDEX];

        if (unparsedCharacterConfiguration.contains(COMPLETION_MARK_SEPARATOR)) {
            String completion = configurationGroups[COMPLETION_INDEX];
            return parseCharacter(unparsedCharacter, calculateCompletionWeight(completion));
        }

        return parseCharacter(unparsedCharacter, DEFAULT_COMPLETION_WEIGHT);
    }

    private static Integer calculateCompletionWeight(String completion) {

        List<String> completions = CompletionParser.parse(completion);
        return CompletionWeightCalculator.calculate(completions);
    }

    private static Character parseCharacter(String unparsedCharacter, Integer completionWeight) {

        String[] characterProperties = unparsedCharacter.split(CHARACTER_PROPERTIES_SEPARATOR);

        checksIfNameAndWeightIsProvided(characterProperties);

        String name = characterProperties[NAME_INDEX];
        String unparsedWeight = characterProperties[WEIGHT_INDEX].strip();
        checksIfWeightIsNumeric(unparsedWeight);

        Weight totalWeight = Weight.of(Integer.parseInt(unparsedWeight) + completionWeight);
        return new Character(name, totalWeight);
    }

    private static void checksIfNameAndWeightIsProvided(String[] characterProperties) {

        if (characterProperties.length < 2) {
            throw new IllegalArgumentException("Name and weight required");
        }
    }

    private static void checksIfWeightIsNumeric(String unparsedWeight) {

        if (!StringUtils.isNumeric(unparsedWeight) || unparsedWeight.isBlank()) {
            throw new IllegalArgumentException("Provided weight is not a number");
        }
    }
}
