import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

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
}
