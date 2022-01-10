package characterpicker.domain;

import java.util.Objects;

public class Weight {
    private static final int WEIGHT_MIN_VALUE = 0;
    private static final int WEIGHT_MAX_VALUE = 10_000;
    private final int value;

    private Weight(int value) {
        this.value = value;
    }

    public static Weight of(int value) {
        if (value <= WEIGHT_MIN_VALUE || value >= WEIGHT_MAX_VALUE) {
            throw new IllegalArgumentException("Weight out of boundaries");
        }
        return new Weight(value);
    }

    public Weight plus(Weight edenWeight) {
        return Weight.of(value + edenWeight.value);
    }

    public int getAsInt() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Weight weight = (Weight) o;
        return value == weight.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
