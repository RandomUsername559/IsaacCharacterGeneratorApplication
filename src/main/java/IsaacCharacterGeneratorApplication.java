import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class IsaacCharacterGeneratorApplication {
    public static void main(String[] args) {
        IsaacCharactersRepository isaacCharactersRepository = new IsaacCharactersRepository();
        List<String> issacCharacters = isaacCharactersRepository.getCharacters();
//        RandomCharacterPicker randomCharacterPicker = new RandomCharacterPicker();
//        String character = randomCharacterPicker.pick(issacCharacters);
    }
}


