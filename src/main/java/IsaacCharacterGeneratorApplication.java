import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class IsaacCharacterGeneratorApplication {
    private List<Character> characters;
    private int[] completionPoints;
    private List<Integer> arrayOfAlternateSums;
    private int sumOfWeights;
    private Random randomResult;

    public IsaacCharacterGeneratorApplication(List<Character> characters, int[] completionPoints) {
        this.characters = characters;
        this.completionPoints = completionPoints;
    }

    public void initialize() {
        randomResult = new Random();

        arrayOfAlternateSums = new ArrayList<>();
        int sumTillNow = 0;
        for (int i = 0; i < characters.size(); i++) {
            Character character = characters.get(i);
            sumTillNow += character.getWeight();
            sumOfWeights += character.getWeight();

            arrayOfAlternateSums.add(i, sumTillNow);

            Integer alternativeSum = arrayOfAlternateSums.get(i);
            alternativeSum += completionPoints[i];
            arrayOfAlternateSums.add(i, alternativeSum);
        }
    }

    String getRandomElement() {
        int random = randomResult.nextInt(sumOfWeights - 1);
        int sample = random + 1;
        int index = Arrays.binarySearch(arrayOfAlternateSums, sample);
        if (index < 0) {
            index = -(index + 1);
        }
        return characters[index];
    }


    public static void main(String[] args) {
        List<Character> characters = List.of(
                new Character("Isaac", 1),
                new Character("Judas", 2),
                new Character("Eden", 3),
                new Character("Lost", 4),
                new Character("Eve", 5)
        );
        int[] completionPoints = {1, 1, 1, 1, 1};
        IsaacCharacterGeneratorApplication characterGenerator = new IsaacCharacterGeneratorApplication(characters, completionPoints);
        characterGenerator.initialize();
        for (int i = 0; i < 5; i++) {
            String character = characterGenerator.getRandomElement();
            System.out.println(character);
        }


        IsaacCharactersRepository isaacCharactersRepository = new IsaacCharactersRepository();
        List<String> issacCharacters = isaacCharactersRepository.getCharacters();
        RandomCharacterPicker randomCharacterPicker = new RandomCharacterPicker();
        String character = randomCharacterPicker.pick(issacCharacters);

    }
}


