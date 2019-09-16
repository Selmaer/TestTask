import Lines.Exceptions.OutOfTaskConditionsException;
import Lines.Query;
import Lines.WaitingTimeLine;

import java.util.ArrayList;

public class Task {
    ArrayList<String> lines;
    ArrayList<Query> queries = new ArrayList<>();
    ArrayList<WaitingTimeLine> waitingTimeLines = new ArrayList<>();

    private void define() throws OutOfTaskConditionsException {
        for (String line : lines) {
            String[] lineArray = line.split(" ");
            if (lineArray[0].equals("D")) {
                Query q = new Query(lineArray);
                queries.add(q);
            } else if (lineArray[0].equals("C")) {
                WaitingTimeLine wtl = new WaitingTimeLine(lineArray);
                waitingTimeLines.add(wtl);
            }
        }
    }

    public static void main(String[] args) throws OutOfTaskConditionsException {
        Task task = new Task();
        InputData inputData = new InputData();
        task.lines = inputData.read();
        task.define();
    }
}
