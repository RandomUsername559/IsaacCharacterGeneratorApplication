package characterpicker.infrastructure;

import characterpicker.Reader;
import characterpicker.domain.Character;

import java.util.ArrayList;
import java.util.List;

public class ConsoleCharacterInputAdapter {

    private final Reader  reader;

    public ConsoleCharacterInputAdapter(Reader reader) {
        this.reader = reader;
    }

    public List<Character> getCharacters() {

        List<Character> characters = new ArrayList<>();

        reader.write("Type characters names from which you want to roll:");
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
