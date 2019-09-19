package Task;

import Task.Input.InputData;
import Task.Lines.Query;
import Task.Lines.WaitingTimeLine;

import java.util.ArrayList;

public class Task {

    public static void main(String[] args) {
        System.out.println("Please, enter your input");
        InputData inputData = new InputData();

        ArrayList<Query> queries = inputData.getQueries();
        ArrayList<WaitingTimeLine> waitingTimeLines = inputData.getWaitingTimeLines();

        System.out.println();

        for (Query query : queries) {
            System.out.println(query.getAverageWaitingTime(waitingTimeLines));
        }
    }
}