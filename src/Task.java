import Input.InputData;
import Lines.Query;
import Lines.WaitingTimeLine;

import java.util.ArrayList;

public class Task {

    public static void main(String[] args) {
        InputData inputData = new InputData();

        ArrayList<Query> queries = inputData.getQueries();
        ArrayList<WaitingTimeLine> waitingTimeLines = inputData.getWaitingTimeLines();
    }
}