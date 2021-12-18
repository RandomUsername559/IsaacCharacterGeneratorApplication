package characterpicker.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class WeightTest {

    @Test
    void shouldAddTwoPositiveWeights() {
        //GIVEN
        Weight firstWeight = Weight.of(1);
        Weight secondWeight = Weight.of(2);

        //WHEN
        Weight sumOfWeights = firstWeight.plus(secondWeight);
        //THEN
        Assertions.assertThat(sumOfWeights).isEqualTo(Weight.of(3));
    }

    @Test
    void shouldThrowExceptionWhenWeightIsJustBeforeLowerBoundaryEdge() {
        //WHEN && THEN
        Assertions.assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> Weight.of(-1))
                .withMessage("Weight out of boundaries");
    }

    @Test
    void shouldThrowExceptionWhenWeightIsLowerOnBoundaryEdge() {
        //WHEN && THEN
        Assertions.assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> Weight.of(0))
                .withMessage("Weight out of boundaries");
    }

    @Test
    void shouldThrowExceptionWhenWeightIsUpperOnBoundaryEdge() {
        //WHEN && THEN
        Assertions.assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> Weight.of(10_000))
                .withMessage("Weight out of boundaries");
    }

    @Test
    void shouldThrowExceptionWhenWeightIsJustBeforeUpperBoundaryEdge() {
        //WHEN && THEN
        Assertions.assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> Weight.of(10_001))
                .withMessage("Weight out of boundaries");
    }

    @Test
    void shouldCreateWeightWhenValueIsJustBeforeLowerBoundaryEdge() {
        //WHEN && THEN
        Assertions.assertThatNoException()
                .isThrownBy(() -> Weight.of(1));
    }

    @Test
    void shouldCreateWeightWhenValueIsJustBeforeUpperBoundaryEdge() {
        //WHEN && THEN
        Assertions.assertThatNoException()
                .isThrownBy(() -> Weight.of(9_999));
    }
}