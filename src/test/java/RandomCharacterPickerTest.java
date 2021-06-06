import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class RandomCharacterPickerTest {

    @Test
    void shouldThrowExceptionWhenEmptyListIsPassed() {
        // GIVEN
        List<String> noCharacters = Collections.emptyList();

        // WHEN && THEN
        Assertions.assertThrows(IllegalArgumentException.class, () -> new RandomCharacterPicker().pick(noCharacters));
    }

    @Test
    void shouldThrowExceptionWhenNullIsPassed() {
        // GIVEN
        List<String> nullList = null;

        // WHEN && THEN
        Assertions.assertThrows(IllegalArgumentException.class, () -> new RandomCharacterPicker().pick(nullList));
    }

    @Test
    void shouldReturnTheSameCharacterThatIsInList() {
        // GIVEN
        String onlyCharacterInCollection = "Isaac";
        List<String> singularCharacter = List.of(onlyCharacterInCollection);

        // WHEN
        String result = new RandomCharacterPicker().pick(singularCharacter);

        // THEN
        Assertions.assertEquals(onlyCharacterInCollection, result);
    }

    @Test
    void shouldReturnRandomCharacterForMultipleElementList() {
        // GIVEN
        int randomGenerations = 1000;
        List<String> characterPool = Arrays.asList("Isaac", "Eden", "Cain");
        int expectedProbability = randomGenerations / characterPool.size();
        RandomCharacterPicker randomCharacterPicker = new RandomCharacterPicker();
        List<String> pickingResults = new ArrayList<>();
        // WHEN

        for (int i = 0; i < randomGenerations; i++) {
            randomCharacterPicker.pick(characterPool);
            pickingResults.add(randomCharacterPicker.pick(characterPool));
        }

        // THEN
        Map<String, Long> charactersOccurrences = pickingResults.stream()
                                                                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        for (Long occurrence : charactersOccurrences.values()) {
            Assertions.assertEquals(expectedProbability, occurrence, 40);

        }
    }
}
