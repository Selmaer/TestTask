package Task.Input;

import Task.Exceptions.OutOfTaskConditionsException;
import Task.Lines.Query;
import Task.Lines.WaitingTimeLine;

import java.util.ArrayList;
import java.util.Scanner;

public class InputData {
    private ArrayList<Query> queries = new ArrayList<>();
    private ArrayList<WaitingTimeLine> waitingTimeLines = new ArrayList<>();

    private void readInputData() throws OutOfTaskConditionsException {
        Scanner scanner = new Scanner(System.in);
        int linesNumber = scanner.nextInt();
        scanner.nextLine();
        ArrayList<InputLine> lines = new ArrayList<>(linesNumber);
        for (int i = 0; i < linesNumber; i++) {
            lines.add(new InputLine(scanner.nextLine()));
        }
        scanner.close();
        define(lines);
    }

    private void define(ArrayList<InputLine> lines) throws OutOfTaskConditionsException {
        for (InputLine line : lines) {
            if (line.getDefiningChar().equals("D")) {
                Query q = new Query(line);
                queries.add(q);
            } else if (line.getDefiningChar().equals("C")) {
                WaitingTimeLine wtl = new WaitingTimeLine(line);
                waitingTimeLines.add(wtl);
            } else {
                throw new OutOfTaskConditionsException();
            }
        }
    }

    public InputData() {
        try {
            readInputData();
        } catch (OutOfTaskConditionsException e) {
            System.out.println("Data you've entered do not match task conditions");
        }
    }

    public ArrayList<Query> getQueries() {
        return queries;
    }

    public ArrayList<WaitingTimeLine> getWaitingTimeLines() {
        return waitingTimeLines;
    }
}
