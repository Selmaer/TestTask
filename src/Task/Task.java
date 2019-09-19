package Task;

import Task.Input.InputData;
import Task.Lines.Query;
import Task.Lines.WaitingTimeLine;

import java.util.ArrayList;

public class Task {

    public static void main(String[] args) {
        InputData inputData = new InputData();

        ArrayList<Query> queries = inputData.getQueries();
        ArrayList<WaitingTimeLine> waitingTimeLines = inputData.getWaitingTimeLines();

        for (Query query : queries) {
            System.out.println(query.getAverageWaitingTime(waitingTimeLines));
        }
    }
}