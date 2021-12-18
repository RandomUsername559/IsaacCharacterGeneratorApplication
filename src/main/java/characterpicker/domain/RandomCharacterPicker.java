package characterpicker.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomCharacterPicker {
    private final Random random = new Random();

    public String pick(List<Character> issacCharacters) {
        validateEmptyOrNull(issacCharacters);
        List<String> characterPool = fillCharacterPool(issacCharacters);
        return pickRandomCharacter(characterPool);

    }

    private void validateEmptyOrNull(List<Character> issacCharacters) {
        if (issacCharacters == null || issacCharacters.isEmpty()) {
            throw new IllegalArgumentException();
        }
    }

    private List<String> fillCharacterPool(List<Character> issacCharacters) {
        List<String> characterPool = new ArrayList<>();
        for (Character issacCharacter : issacCharacters) {
            Weight weight = issacCharacter.getWeight();
            for (int i = 0; i < weight.getAsInt(); i++) {
                characterPool.add(issacCharacter.getName());
            }
        }
        return characterPool;
    }

    private String pickRandomCharacter(List<String> characterPool) {
        int randomInt = random.nextInt(characterPool.size());
        return characterPool.get(randomInt);
    }

}

