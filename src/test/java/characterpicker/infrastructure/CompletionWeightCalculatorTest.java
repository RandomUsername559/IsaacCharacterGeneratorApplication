package characterpicker.infrastructure;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;


class CompletionWeightCalculatorTest {

    @Test
    void shouldDownscaleWeightIfSumOfValesIsLessThanHalf() {
        //GIVEN
        List<String> completionsThatSumUpToLessThanHalf = List.of(
                "isaac",
                "satan",
                "boss rush",
                "???"
        );

        //WHEN && THEN
        Assertions.assertThat(CompletionWeightCalculator.calculate(completionsThatSumUpToLessThanHalf))
                .isZero();
    }

    @Test
    void shouldReturnAProperRoundedWeightFromOneElementList() {

        //GIVEN
        List<String> singularCompletion = List.of(
                "delirium"
        );

        //WHEN && THEN
        Assertions.assertThat(CompletionWeightCalculator.calculate(singularCompletion))
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
        Assertions.assertThat(CompletionWeightCalculator.calculate(listOfMixedInputs))
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
        Assertions.assertThat(CompletionWeightCalculator.calculate(listOfMatchingInputs))
                .isEqualTo(2);
    }

    @Test
    void shouldReturnZeroWhenProvidedListIsEmpty() {

        //GIVEN
        List<String> emptyList = List.of(
        );

        //WHEN && THEN
        Assertions.assertThat(CompletionWeightCalculator.calculate(emptyList))
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
        Assertions.assertThat(CompletionWeightCalculator.calculate(listOfUnmatchingElements))
                .isZero();
    }

}

