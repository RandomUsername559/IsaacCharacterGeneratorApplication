import java.util.ArrayList;
import java.util.List;

public class ObjectsTest {

    private final static List<Person> PEOPLE = new ArrayList<>();

    public static void aa() {
        Occupation myOccupation = new Occupation("sdgsdg", 3456f);
        Adress myAdress = new Adress("kljnsf", "jhv");
        Person myPerson = new Person(50f, 23f, "kjn", myAdress, myOccupation);

        myPerson.setPrice(1000f);
        System.out.println(myPerson);

        PEOPLE.add(myPerson);

        Occupation myOccupation2 = new Occupation("Kebab", 2345f);
        Person myPerson2 = new Person(200f, 40f, "Test", null, myOccupation2);
        System.out.println(myPerson2);

        PEOPLE.add(myPerson2);

        Occupation myOccupation3 = new Occupation("Kebab", 2345f);
        Person myPerson3 = new Person(90f, 9f, "Kebab", null, myOccupation3);

        System.out.println(myPerson3);
        PEOPLE.add(myPerson3);
    }
}



