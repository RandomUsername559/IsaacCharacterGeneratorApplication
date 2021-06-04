public class Person {
    private Float price;
    private Float damage;
    private String name;
    private Adress personAdress;
    private Occupation personOccupation;

    public Person(Float price, Float damage, String name, Adress personAdress, Occupation personOccupation) {
        setPrice(price);
        this.damage = damage;
        this.name = name;
        this.personAdress = personAdress;
        this.personOccupation = personOccupation;
    }

    public void setPrice(Float price) {
        this.price = price * 1.10f;
    }

    public Float getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Person{" +
                "price=" + price +
                ", damage=" + damage +
                ", name='" + name + '\'' +
                ", personAdress=" + personAdress +
                ", personOccupation=" + personOccupation +
                '}';
    }
}
