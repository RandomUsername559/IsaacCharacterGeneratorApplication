package characterpicker.console;

import java.util.Scanner;

public class ConsoleReader implements Reader {

   private static final Scanner scanner = new Scanner(System.in);

    @Override
    public void write(String text) {
        System.out.println(text);
    }

    @Override
    public String read() {
        return scanner.nextLine();
    }
}
