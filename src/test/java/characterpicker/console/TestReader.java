package characterpicker.console;

import java.util.List;

public class TestReader implements Reader {

    public static final String END_OF_USER_INPUT = "";
    private final List<String> mockedUserInputList;
    private int index = 0;

    public TestReader(List<String> mockedUserInputList) {
        this.mockedUserInputList = mockedUserInputList;
    }

    @Override
    public void write(String text) {
        //Do nothing test do not need to write anything to console
    }

    @Override
    public String read() {
        if (listIsRead()) {
            return END_OF_USER_INPUT;
        }

        String unparsedCharacter = mockedUserInputList.get(index);
        moveToNextLine();
        return unparsedCharacter;
    }

    private int moveToNextLine() {
        return index++;
    }

    private boolean listIsRead() {
        return mockedUserInputList.size() == index;
    }
}
