import java.util.ArrayList;
import java.util.Scanner;

public class InputReader {
    Scanner scanner = new Scanner(System.in);
    public ArrayList read () {
        int linesNumber = scanner.nextInt();
        ArrayList<String> lines = new ArrayList<>(linesNumber);
        for (int i = 0; i <= linesNumber; i++) {
            lines.add(scanner.nextLine());
        }
        return lines;
    }
}
