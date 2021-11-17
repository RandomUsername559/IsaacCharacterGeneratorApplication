import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ConsoleCharacterRepository {


//    List<Integer> charactersWeightsList = new ArrayList<>();
//    Scanner weightsInput = new Scanner(System.in);

    public List<Character> getCharacters() {
        List<Character> charactersNamesList = new ArrayList<>();
        Scanner namesInput = new Scanner(System.in);

        System.out.println("Type character names from which you want to roll:");

        while (true) {

            String characterName = namesInput.nextLine();

            if (characterName.length() == 0) {
                break;
            } else {
                Character character = new Character(characterName);
                charactersNamesList.add(character);

            }

        }

//        for (int i = 0; i < charactersNamesList.size(); i++) {
//            System.out.println("From scale 0-5 how much u like this character : " + charactersNamesList.get(i));
//            charactersWeightsList.add(weightsInput.nextInt());
//        }
//        weightsInput.close();

        return charactersNamesList;
    }

}

