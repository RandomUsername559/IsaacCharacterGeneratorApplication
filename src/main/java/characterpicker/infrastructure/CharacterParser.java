package characterpicker.infrastructure;

import characterpicker.domain.Character;
import org.apache.commons.lang.StringUtils;

public class CharacterParser {
    private CharacterParser(){
        throw new IllegalStateException("Utility class");
    }

    static Character parseCharacter(String unparsedCharacter) {

        String[] characterProperties = unparsedCharacter.split(",");
        if (characterProperties.length < 2) {
            throw new IllegalArgumentException("Name and weight required");
        }
        String name = characterProperties[0];
        String unparsedWeight = characterProperties[1];
        if (!StringUtils.isNumeric(unparsedWeight)) {
            throw new IllegalArgumentException("Provided weight is not a number");
        }


        int weight = Integer.parseInt(unparsedWeight);

        return new Character(name, weight);
    }
}
