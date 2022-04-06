package characterpicker.console;

import characterpicker.core.Character;
import characterpicker.core.CharacterParser;

import java.util.ArrayList;
import java.util.List;

public class ConsoleCharacterInputAdapter {

    private final Reader  reader;

    public ConsoleCharacterInputAdapter(Reader reader) {
        this.reader = reader;
    }

    public List<Character> getCharacters() {

        List<Character> characters = new ArrayList<>();

        reader.write("Type character's names from which you want to roll:");
        while (true) {

            String unparsedCharacter = reader.read();

            if (characterAddingEnded(unparsedCharacter)) {
                break;
            }
            Character character = CharacterParser.parseCharacter(unparsedCharacter);
            characters.add(character);
        }

        reader.write(characters.toString());
        if (characters.isEmpty()) {
            throw new IllegalArgumentException("At least one character has to be provided");
        }
        return characters;
    }

    private boolean characterAddingEnded(String unparsedCharacter) {
        return unparsedCharacter.length() == 0;

    }

}
