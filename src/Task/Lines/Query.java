package Task.Lines;

import Task.Exceptions.OutOfTaskConditionsException;
import Task.Input.InputLine;
import Task.Lines.Data.Date;
import Task.Lines.Data.Question;
import Task.Lines.Data.ResponseType;
import Task.Lines.Data.Service;

import java.time.LocalDate;
import java.util.ArrayList;

public class Query extends Line {

    private LocalDate dateFrom;
    private LocalDate dateTo;

    private void setDates(String date) throws OutOfTaskConditionsException {

        String[] dates = date.split("-");
        if (dates.length == 1) {
            dateFrom = Date.toLocalDate(dates[0]);
            dateTo = dateFrom;
        } else if (dates.length == 2) {
            dateFrom = Date.toLocalDate(dates[0]);
            dateTo = Date.toLocalDate(dates[1]);
        } else {
            throw new OutOfTaskConditionsException();
        }
    }

    private boolean includes(WaitingTimeLine wtl) {
        return
                (wtl.getDate().compareTo(dateFrom) >= 0 && wtl.getDate().compareTo(dateTo) <= 0) &&
                        this.service.includes(wtl.getService()) &&
                        this.question.includes(wtl.getQuestion()) &&
                        this.responseType == wtl.getResponseType();
    }

    private ArrayList<WaitingTimeLine> getMatches(ArrayList<WaitingTimeLine> waitingTimeLines) {
        ArrayList<WaitingTimeLine> matchingWtl = new ArrayList<>();
        for (WaitingTimeLine wtl : waitingTimeLines) {
            if (this.includes(wtl)) {
                matchingWtl.add(wtl);
            }
        }
        return matchingWtl;
    }

    public Query(InputLine line) throws OutOfTaskConditionsException {
        this.service = new Service(line.getServiceStr());
        this.question = new Question(line.getQuestionStr());
        this.responseType = ResponseType.set(line.getResponseType());
        setDates(line.getDate());
    }

    public String getAverageWaitingTime(ArrayList<WaitingTimeLine> waitingTimeLines) {
        ArrayList<WaitingTimeLine> matchingWtl = this.getMatches(waitingTimeLines);
        if (matchingWtl.isEmpty()) {
            return "-";
        } else {
            float waitingTime = 0;
            for (WaitingTimeLine wtl : matchingWtl) {
                waitingTime += wtl.getWaitingTime();
            }
            return String.valueOf(Math.round(waitingTime / matchingWtl.size()));
        }
    }
}