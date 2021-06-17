import java.util.List;
import java.util.Random;

public class RandomCharacterPicker {
    private final Random random = new Random();

    public String pick(List<Character> issacCharacters) {

        if (issacCharacters == null || issacCharacters.isEmpty()) {
            throw new IllegalArgumentException();
        }

        int randomInt = random.nextInt(issacCharacters.size());
        Character character = issacCharacters.get(randomInt);
        return character.getName();

    }

}
