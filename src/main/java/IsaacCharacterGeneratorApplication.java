import java.util.List;

public class IsaacCharacterGeneratorApplication {
    public static void main(String[] args) {
        ConsoleCharacterRepository characterRepository = new ConsoleCharacterRepository();
        List<Character> issacCharacters = characterRepository.getCharacters();
        RandomCharacterPicker randomCharacterPicker = new RandomCharacterPicker();
        String character = randomCharacterPicker.pick(issacCharacters);
        System.out.println(character);

    }




}


