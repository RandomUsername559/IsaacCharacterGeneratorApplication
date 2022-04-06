package characterpicker.core;

import com.google.common.collect.Range;
import com.google.common.collect.RangeMap;
import com.google.common.collect.TreeRangeMap;

import java.util.List;
import java.util.Random;


public class RandomCharacterPicker {

    private final Random random = new Random();

    @SuppressWarnings("UnstableApiUsage")
    public String pick(List<Character> issacCharacters) {
        validateEmptyOrNull(issacCharacters);
        RangeMap<Integer, String> characterPool = fillCharacterPool(issacCharacters);
        return pickRandomCharacter(characterPool);
    }

    private void validateEmptyOrNull(List<Character> issacCharacters) {
        if (issacCharacters == null || issacCharacters.isEmpty()) {
            throw new IllegalArgumentException();
        }
    }

    @SuppressWarnings("UnstableApiUsage")
    private RangeMap<Integer, String> fillCharacterPool(List<Character> issacCharacters) {

        RangeMap<Integer, String> characterPool = TreeRangeMap.create();

        int rangeStart = 1;

        for (Character issacCharacter : issacCharacters) {
            int rangeEnd = issacCharacter.getWeight().getAsInt() + rangeStart;

            characterPool.put(Range.closed(rangeStart, rangeEnd - 1), issacCharacter.getName());

            rangeStart = rangeEnd;
        }
        return characterPool;
    }

    @SuppressWarnings("UnstableApiUsage")
    private String pickRandomCharacter(RangeMap<Integer, String> characterPool) {
        Integer maxWeight = characterPool.asMapOfRanges()
                .keySet()
                .stream()
                .map(Range::upperEndpoint)
                .max(Integer::compare)
                .orElseThrow(() -> new RuntimeException("Impossible to have empty range map"));

        int rolledNumber = random.nextInt(maxWeight) + 1;

        return characterPool.get(rolledNumber);
    }

}

