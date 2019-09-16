package Lines;

import Lines.Data.Date;
import Lines.Data.Question;
import Lines.Data.ResponseType;
import Lines.Data.Service;
import Lines.Exceptions.OutOfTaskConditionsException;

import java.time.LocalDate;

public class WaitingTimeLine extends Line {
    LocalDate date;
    int time;

    public WaitingTimeLine(String[] lineArray) throws OutOfTaskConditionsException {
        this.service = new Service(lineArray[1]);
        this.question = new Question(lineArray[2]);
        this.responseType = ResponseType.set(lineArray[3]);
        date = Date.toLocalDate(lineArray[4]);
        time = Integer.parseInt(lineArray[5]);
    }
}