package Lines;

import Lines.Data.Date;
import Lines.Data.Question;
import Lines.Data.ResponseType;
import Lines.Data.Service;
import Lines.Exceptions.OutOfTaskConditionsException;

import java.time.LocalDate;

public class Query extends Line {

    LocalDate dateFrom;
    LocalDate dateTo;

    public Query(String[] lineArray) throws OutOfTaskConditionsException {
        this.service = new Service(lineArray[1]);
        this.question = new Question(lineArray[2]);
        this.responseType = ResponseType.set(lineArray[3]);
        String[] dates = lineArray[4].split("-");
        dateFrom = Date.toLocalDate(dates[0]);
        dateTo = Date.toLocalDate(dates[1]);
    }
}