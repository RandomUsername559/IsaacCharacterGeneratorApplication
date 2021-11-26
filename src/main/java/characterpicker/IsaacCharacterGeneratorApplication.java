package characterpicker;

import characterpicker.domain.Character;
import characterpicker.domain.RandomCharacterPicker;
import characterpicker.infrastructure.ConsoleCharacterInputAdapter;
import characterpicker.infrastructure.ConsoleReader;

import java.util.List;

public class IsaacCharacterGeneratorApplication {
    public static void main(String[] args) {
        ConsoleCharacterInputAdapter characterRepository = new ConsoleCharacterInputAdapter(new ConsoleReader());
        List<Character> issacCharacters = characterRepository.getCharacters();
        RandomCharacterPicker randomCharacterPicker = new RandomCharacterPicker();
        String character = randomCharacterPicker.pick(issacCharacters);
        System.out.println(character);

    }




}


