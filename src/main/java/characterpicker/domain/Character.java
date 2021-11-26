package characterpicker.domain;

import java.util.Objects;

public class Character {
    private final String name;
    private final int weight;


    public Character(String name) {
        this.name = name;
        this.weight = 1;

    }

    public Character(String name, int weight) {
        this.name = name;
        this.weight = weight;

    }

    public int getWeight() {
        return weight;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Character character = (Character) o;
        return weight == character.weight && Objects.equals(name, character.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, weight);
    }

    @Override
    public String toString() {
        return name + " " + weight;
    }
}
