import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class IsaacCharactersRepository {
    private static final ObjectMapper objectMapper = new ObjectMapper();

    public List<String> getCharacters() {
        try {
            return objectMapper.readValue(new File("src/main/resources/characters.json"), new TypeReference<>() {});
        } catch (IOException e) {
            e.printStackTrace();
            throw new UnsupportedOperationException();
        }
    }
}
