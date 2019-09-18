package Lines;

import Input.InputLine;
import Lines.Data.Date;
import Lines.Data.Question;
import Lines.Data.ResponseType;
import Lines.Data.Service;
import Lines.Exceptions.OutOfTaskConditionsException;

import java.time.LocalDate;

public class WaitingTimeLine extends Line {
    LocalDate date;
    int time;

    public WaitingTimeLine(InputLine line) throws OutOfTaskConditionsException {
        this.service = new Service(line.getServiceStr());
        this.question = new Question(line.getQuestionStr());
        this.responseType = ResponseType.set(line.getResponseType());
        date = Date.toLocalDate(line.getDate());
        time = Integer.parseInt(line.getTime());
    }

    public LocalDate getDate() {
        return date;
    }

    public int getTime() {
        return time;
    }
}