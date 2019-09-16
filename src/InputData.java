import java.util.ArrayList;
import java.util.Scanner;

public class InputData {
    ArrayList<String> lines;

    public ArrayList<String> read() {
        Scanner scanner = new Scanner(System.in);
        int linesNumber = scanner.nextInt();
        scanner.nextLine();
        lines = new ArrayList<>(linesNumber);
        for (int i = 0; i < linesNumber; i++) {
            lines.add(scanner.nextLine());
        }
        scanner.close();
        return lines;
    }
}
