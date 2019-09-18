package Lines;

import Input.InputLine;
import Lines.Data.Date;
import Lines.Data.Question;
import Lines.Data.ResponseType;
import Lines.Data.Service;
import Lines.Exceptions.OutOfTaskConditionsException;

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