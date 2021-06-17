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
}
