package characterpicker.infrastructure;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;


 class CompletionWeightCalculatorTest {
     //TO DO test na wartość 0

    @Test
    void shouldReturnAProperRoundedWeightFromOneElementList() {

        //GIVEN
        List<String>singularCompletion= List.of(
                "delirium"
        );

        //WHEN && THEN
        Assertions.assertThat(CompletionWeightCalculator.calculateCompletionWeight(singularCompletion))
                .isEqualTo(1);
    }

    @Test
    void shouldReturnProperRoundedWeightFromMixedList() {

        //GIVEN
        List<String> listOfMixedInputs = List.of(
                "a",
                "mother",
                "b",
                "isaac"
        );

        //WHEN && THEN
        Assertions.assertThat(CompletionWeightCalculator.calculateCompletionWeight(listOfMixedInputs))
                .isEqualTo(1);
    }
    @Test
    void shouldReturnProperRoundedWeightFromMultipleMatchingElementList() {

        //GIVEN
        List<String> listOfMatchingInputs = List.of(
                "isaac",
                "mother",
                "satan",
                "hush",
                "delirium",
                "mega satan"
        );

        //WHEN && THEN
        Assertions.assertThat(CompletionWeightCalculator.calculateCompletionWeight(listOfMatchingInputs))
                .isEqualTo(2);
    }

    @Test
    void shouldReturnZeroWhenProvidedListIsEmpty() {

        //GIVEN
        List<String> emptyList = List.of(
        );

        //WHEN && THEN
        Assertions.assertThat(CompletionWeightCalculator.calculateCompletionWeight(emptyList))
                .isZero();
    }

    @Test
    void shouldReturnZeroWhenNeitherElementMatchesThoseOnList() {

        //GIVEN
        List<String> listOfUnmatchingElements = List.of(
                "a",
                "b",
                "c"
        );

        //WHEN && THEN
        Assertions.assertThat(CompletionWeightCalculator.calculateCompletionWeight(listOfUnmatchingElements))
                .isZero();
    }

}

