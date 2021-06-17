import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class RandomCharacterPickerTest {
    private final RandomCharacterPicker randomCharacterPicker = new RandomCharacterPicker();

    @Test
    void shouldThrowExceptionWhenEmptyListIsPassed() {
        // GIVEN
        List<Character> noCharacters = Collections.emptyList();

        // WHEN && THEN
        Assertions.assertThrows(IllegalArgumentException.class, () -> randomCharacterPicker.pick(noCharacters));
    }

    @Test
    void shouldThrowExceptionWhenNullIsPassed() {
        // GIVEN
        List<Character> nullList = null;

        // WHEN && THEN
        Assertions.assertThrows(IllegalArgumentException.class, () -> randomCharacterPicker.pick(nullList));
    }

    @Test
    void shouldReturnTheSameCharacterThatIsInList() {
        // GIVEN
        String onlyCharacterInCollection = "Isaac";
        List<Character> singularCharacter = List.of(new Character(onlyCharacterInCollection));

        // WHEN
        String result = randomCharacterPicker.pick(singularCharacter);

        // THEN
        Assertions.assertEquals(onlyCharacterInCollection, result);
    }

    @Test
    void shouldReturnRandomCharacterForMultipleElementList() {
        // GIVEN
        int randomGenerations = 1000;
        List<Character> characterPool = List.of(
                new Character("Isaac"),
                new Character("Eden"),
                new Character("Cain")
        );
        int expectedProbability = randomGenerations / characterPool.size();
        List<String> pickingResults = new ArrayList<>();

        // WHEN
        for (int i = 0; i < randomGenerations; i++) {
            pickingResults.add(randomCharacterPicker.pick(characterPool));
        }

        // THEN
        Map<String, Long> charactersOccurrences = pickingResults.stream()
                                                                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        for (Long occurrence : charactersOccurrences.values()) {
            Assertions.assertEquals(expectedProbability, occurrence, 40);

        }
    }

    @Test
    void shouldReturnTheSameCharacterWithWeightThatIsInList() {
        // GIVEN
        String onlyCharacterInCollection = "Isaac";
        List<Character> singularCharacter = List.of(new Character(onlyCharacterInCollection, 2));

        // WHEN
        String result = randomCharacterPicker.pick(singularCharacter);

        // THEN
        Assertions.assertEquals(onlyCharacterInCollection, result);
    }

    @Test
    void shouldReturnRandomWeightedCharacterForMultipleElementList() {
        // GIVEN
        int randomGenerations = 1000;
        int issacWeight = 1;
        int edenWeight = 2;
        int cainWeight = 3;
        int weightSum = issacWeight + edenWeight + cainWeight;

        Map<String, Double> expectedProbabilities = Map.of(
                "Isaac", (double) issacWeight / (double) weightSum,
                "Eden", (double) edenWeight / (double) weightSum,
                "Cain", (double) cainWeight / (double) weightSum
        );
        List<Character> characterPool = List.of(
                new Character("Isaac", issacWeight),
                new Character("Eden", edenWeight),
                new Character("Cain", cainWeight)
        );
        List<String> pickingResults = new ArrayList<>();

        // WHEN
        for (int i = 0; i < randomGenerations; i++) {
            pickingResults.add(randomCharacterPicker.pick(characterPool));
        }

        // THEN
        Map<String, Long> charactersOccurrences = pickingResults.stream()
                                                                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        for (Map.Entry<String, Long> occurrence : charactersOccurrences.entrySet()) {
            Assertions.assertEquals(expectedProbabilities.get(occurrence.getKey()) * randomGenerations, occurrence.getValue(), 40);
        }
    }
}
