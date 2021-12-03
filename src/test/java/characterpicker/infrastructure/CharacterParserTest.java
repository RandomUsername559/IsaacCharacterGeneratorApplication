package characterpicker.infrastructure;

import characterpicker.domain.Character;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class CharacterParserTest {
    @Test
    void shouldThrowExceptionWhenSpacesSeparatedByCommaIsProvided() {
        //GIVEN
        String emptyInput = "   ,   ; ";

        // WHEN && THEN
        Assertions.assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> CharacterParser.parseCharacter(emptyInput))
                .withMessage("Provided weight is not a number");
    }

    @Test
    void shouldParseCharacter() {
        // GIVEN
        String singularCharacter = "Isaac,1";

        // WHEN
        Character character = CharacterParser.parseCharacter(singularCharacter);

        // THEN
        Character expectedCharacter = new Character("Isaac", 1);
        Assertions.assertThat(character)
                .isEqualTo(expectedCharacter);
    }

    @Test
    void shouldThrowExceptionWhenNotNumberIsProvidedInThePlaceOfNumber() {
        // GIVEN
        String characterWithInvalidWeight = "Isaac,Isaac; ";

        // WHEN && THEN
        Assertions.assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> CharacterParser.parseCharacter(characterWithInvalidWeight))
                .withMessage("Provided weight is not a number");
    }

    @Test
    void shouldThrowExceptionWhenProvidedCharacterContainsOnlyComma() {
        //GIVEN
        String emptyInput = ",";

        // WHEN && THEN
        Assertions.assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> CharacterParser.parseCharacter(emptyInput))
                .withMessage("Name and weight required");
    }

    @Test
    void shouldAcceptEmptyName() {
        // GIVEN
        String characterWithEmptyName = ",1";

        // WHEN
        Character characters = CharacterParser.parseCharacter(characterWithEmptyName);

        // THEN
        Character expectedCharacter = new Character("", 1);
        Assertions.assertThat(characters)
                .isEqualTo(expectedCharacter);
    }
    @Test
    void shouldReturnTheSameCharacterWhenAnythingInCompletionIsProvided() {
        // GIVEN
        String singularCharacter = "Isaac,1";

        // WHEN
        Character character = CharacterParser.parseCharacter(singularCharacter);

        // THEN
        Character expectedCharacter = new Character("Isaac", 1);
        Assertions.assertThat(character)
                .isEqualTo(expectedCharacter);
    }
}
