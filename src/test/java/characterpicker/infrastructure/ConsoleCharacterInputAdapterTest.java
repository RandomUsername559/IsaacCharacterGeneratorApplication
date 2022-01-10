package characterpicker.infrastructure;

import characterpicker.TestReader;
import characterpicker.domain.Character;
import characterpicker.domain.Weight;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class ConsoleCharacterInputAdapterTest {

    @Test
    void shouldThrowExceptionWhenListWithSingleEmptyElementIsPassed() {
        //GIVEN
        List<String> emptyInput = List.of(
                ""
        );
        ConsoleCharacterInputAdapter repository = new ConsoleCharacterInputAdapter(new TestReader(emptyInput));

        // WHEN && THEN
        Assertions.assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(repository::getCharacters)
                .withMessage("At least one character has to be provided");
    }

    @Test
    void shouldIgnoreLastUnfilledInput() {
        // GIVEN
        List<String> singularCharacter = List.of(
                "Isaac,1",
                ""
        );
        ConsoleCharacterInputAdapter repository = new ConsoleCharacterInputAdapter(new TestReader(singularCharacter));

        // WHEN
        List<Character> characters = repository.getCharacters();

        // THEN
        List<Character> expectedCharacter = List.of(
                new Character("Isaac", Weight.of(1))
        );
        Assertions.assertThat(characters)
                .isEqualTo(expectedCharacter);
    }

    @Test
    void shouldReturnTheSameCharacterThatIsInList() {
        // GIVEN
        List<String> singularCharacter = List.of(
                "Isaac,1"
        );
        ConsoleCharacterInputAdapter repository = new ConsoleCharacterInputAdapter(new TestReader(singularCharacter));

        // WHEN
        List<Character> characters = repository.getCharacters();

        // THEN
        List<Character> expectedCharacter = List.of(
                new Character("Isaac", Weight.of(1))
        );
        Assertions.assertThat(characters)
                .isEqualTo(expectedCharacter);
    }

    @Test
    void shouldIterateOverMultipleCharacters() {
        // GIVEN
        List<String> characterUserInputs = List.of(
                "Isaac,1",
                "Magdalene,2",
                "Jacob,1"
        );

        ConsoleCharacterInputAdapter repository = new ConsoleCharacterInputAdapter(new TestReader(characterUserInputs));

        // WHEN
        List<Character> characters = repository.getCharacters();

        //THEN
        List<Character> expectedCharacters = List.of(
                new Character("Isaac", Weight.of(1)),
                new Character("Magdalene", Weight.of(2)),
                new Character("Jacob", Weight.of(1))
        );
        Assertions.assertThat(characters)
                .isEqualTo(expectedCharacters);
    }
}
