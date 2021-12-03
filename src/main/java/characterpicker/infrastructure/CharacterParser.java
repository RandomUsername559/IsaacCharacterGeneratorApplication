package characterpicker.infrastructure;

import characterpicker.domain.Character;
import org.apache.commons.lang.StringUtils;

public class CharacterParser {
    private CharacterParser() {
        throw new IllegalStateException("Utility class");
    }

    static Character parseCharacter(String unparsedCharacter) {

        if (unparsedCharacter.endsWith(">")) {

            String[] unparsedProperties = unparsedCharacter.split("<");

            String nameAndWeight = unparsedProperties[0];
            String completion = unparsedProperties[1];

            String[] characterProperties = nameAndWeight.split(",");

            checksIfNameAndWeightIsProvided(characterProperties);

            String name = characterProperties[0];
            String unparsedWeight = characterProperties[1];

            checksIfWeightIsNumeric(unparsedWeight);

            return new Character(name, weightAddition(unparsedWeight, completion));
        }

        String[] characterProperties = unparsedCharacter.split(",");

        checksIfNameAndWeightIsProvided(characterProperties);

        String name = characterProperties[0];
        String unparsedWeight = characterProperties[1];

        checksIfWeightIsNumeric(unparsedWeight);

        return new Character(name, weightAddition(unparsedWeight, "0"));
    }


    private static void checksIfNameAndWeightIsProvided(String[] characterProperties) {

        if (characterProperties.length < 2) {
            throw new IllegalArgumentException("Name and weight required");
        }
    }

    private static Integer weightAddition(String unparsedWeight, String completion) {

        return (Integer.parseInt(unparsedWeight) + CompletionParser.parseCompletion(completion));
    }

    private static void checksIfWeightIsNumeric(String unparsedWeight) {

        if (!StringUtils.isNumeric(unparsedWeight)) {
            throw new IllegalArgumentException("Provided weight is not a number");
        }
    }
}
