package characterpicker.core;

import characterpicker.console.ConsoleCharacterInputAdapter;
import characterpicker.console.ConsoleReader;
import org.springframework.boot.SpringApplication;

import java.util.List;

public class IsaacCharacterGeneratorApplication {
    public static void main(String[] args) {
        SpringApplication.run(IsaacCharacterGeneratorApplication.class, args);

        ConsoleCharacterInputAdapter characterRepository = new ConsoleCharacterInputAdapter(new ConsoleReader());
        List<Character> issacCharacters = characterRepository.getCharacters();
        RandomCharacterPicker randomCharacterPicker = new RandomCharacterPicker();
        String character = randomCharacterPicker.pick(issacCharacters);
        System.out.println(character);

    }


}


