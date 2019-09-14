package pkg1;

import java.util.ArrayList;
import java.util.Scanner;

public class InputReader {
    Scanner scanner = new Scanner(System.in);
    public ArrayList read () {
        int linesNumber = scanner.nextInt();
        ArrayList<String> lines = new ArrayList<>();
        for (int i = 0; i <= linesNumber; i++) {
            lines.add(scanner.nextLine());
        }
        return lines;
    }

//    public static void main(String[] args) {
//        InputReader r = new InputReader();
//        ArrayList<String> list = r.read();
//        for(String s : list) {
//            System.out.println(s);
//        }
//    }
}
