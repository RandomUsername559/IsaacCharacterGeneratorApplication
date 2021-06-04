import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class IsaacCharacterGeneratorApplication {
    private String[] postacie;
    private int[] wagi;
    private int[] sumaWag;
    private Random randomResault;


    public IsaacCharacterGeneratorApplication(int[] wagi, String[] postacie) {
        {

            this.postacie = postacie;
            this.wagi = wagi;
        }

    }

    public void initialize() {
        randomResault = new Random();

        int sumaDoTeraz = 0;
        sumaWag = new int[wagi.length];
        for (int i = 0; i < wagi.length; i++) {
            sumaDoTeraz += wagi[i];
            sumaWag[i] = sumaDoTeraz;
        }
    }

    String getRandomElement() {
        int losowy = randomResault.nextInt(sumaWag.length - 1);
        int probka = losowy + 1;
        int index = Arrays.binarySearch(sumaWag, probka);
        if (index < 0) {
            index = -(index + 1);
        }
        return postacie[index];
    }


    public static void main(String[] args) {
        String[] postacie = {"Isaac", "Judas", "Eden", "Lost"};
        int[] wagi = {0, 1, 1, 5};
        IsaacCharacterGeneratorApplication generatorPostaci = new IsaacCharacterGeneratorApplication(wagi, postacie);
        generatorPostaci.initialize();
        for (int i = 0; i < 5; i++) {
            String postac = generatorPostaci.getRandomElement();
            System.out.println(postac);
        }


        IsaacCharactersRepository isaacCharactersRepository = new IsaacCharactersRepository();
        List<String> issacCharacters = isaacCharactersRepository.getCharacters();
        RandomCharacterPicker randomCharacterPicker = new RandomCharacterPicker();
        String character = randomCharacterPicker.pick(issacCharacters);

    }
}


