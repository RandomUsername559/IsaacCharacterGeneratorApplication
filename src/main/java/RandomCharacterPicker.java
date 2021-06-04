import java.util.List;

public class RandomCharacterPicker {
    public String pick(List<String> issacCharacters) {

        if (issacCharacters == null || issacCharacters.isEmpty())
         throw new IllegalArgumentException();
        else
            return issacCharacters.get(0);
    }

}
