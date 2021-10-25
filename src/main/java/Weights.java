import java.util.Arrays;
import java.util.Random;

public class Weights {
    private String[] characters;
    private int[] weights;
    private int[] arrayOfAlternateSums;
    private int sumOfWeights;
    private Random randomResult;

    public Weights(int[] weights, String[] characters) {
        {

            this.characters = characters;
            this.weights = weights;
        }

        System.out.println("Test");
    }

    public void calculations() {
        randomResult = new Random();
        arrayOfAlternateSums = new int[weights.length];
        int sumTilNow = 0;
        for (int i = 0; i < weights.length; i++) {
            sumTilNow += weights[i];
            System.out.println(sumTilNow);

        }

    }
    String getRandomElement() {
        int random = randomResult.nextInt(arrayOfAlternateSums.length - 1);
        int sample = random + 1;
        int index = Arrays.binarySearch(arrayOfAlternateSums, sample);
        if (index < 0) {
            index = -(index + 1);
        }
        return characters[index];
    }

    public static void main(String[] args) {
        String[] characters = {"Isaac", "Judas", "Eden", "Lost", "Eve"};
        int[] weights = {0, 1, 2, 3, 4};

        System.out.println();
    }
}
