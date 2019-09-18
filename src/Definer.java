import Input.InputData;
import Lines.Query;
import Lines.WaitingTimeLine;

import java.util.ArrayList;

public class Definer {
    ArrayList<Query> queries;
    ArrayList<WaitingTimeLine> waitingTimeLines;

    public Definer(InputData inputData) {
        queries = inputData.getQueries();
        waitingTimeLines = inputData.getWaitingTimeLines();
    }

    private ArrayList<WaitingTimeLine> define(Query query) {
        ArrayList<WaitingTimeLine> matchingWtl = new ArrayList<>();
        for (WaitingTimeLine wtl : waitingTimeLines) {
            if (query.includes(wtl)) {
                matchingWtl.add(wtl);
            }
        }
        return matchingWtl;
    }

    private String getAverageWaitingTime(ArrayList<WaitingTimeLine> wtl) {
        return "";
    }

    public void printAverageWaitingTime() {
        for (Query query : queries) {
            System.out.println(getAverageWaitingTime(define(query)));
        }
    }
}
