package Task.Lines;

import Task.Exceptions.OutOfTaskConditionsException;
import Task.Input.InputLine;
import Task.Lines.Data.Date;
import Task.Lines.Data.Question;
import Task.Lines.Data.ResponseType;
import Task.Lines.Data.Service;

import java.time.LocalDate;

public class WaitingTimeLine extends Line {
    private LocalDate date;
    private int waitingTime;

    public WaitingTimeLine(InputLine line) throws OutOfTaskConditionsException {
        this.service = new Service(line.getServiceStr());
        this.question = new Question(line.getQuestionStr());
        this.responseType = ResponseType.set(line.getResponseType());
        date = Date.toLocalDate(line.getDate());
        waitingTime = Integer.parseInt(line.getTime());
    }

    public LocalDate getDate() {
        return date;
    }

    public int getWaitingTime() {
        return waitingTime;
    }
}