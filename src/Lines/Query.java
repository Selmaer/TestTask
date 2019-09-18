package Lines;

import Input.InputLine;
import Lines.Data.Date;
import Lines.Data.Question;
import Lines.Data.ResponseType;
import Lines.Data.Service;
import Lines.Exceptions.OutOfTaskConditionsException;

import java.time.LocalDate;

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

    public Query(InputLine line) throws OutOfTaskConditionsException {
        this.service = new Service(line.getServiceStr());
        this.question = new Question(line.getQuestionStr());
        this.responseType = ResponseType.set(line.getResponseType());
        setDates(line.getDate());
    }

    public boolean includes(WaitingTimeLine wtl) {
        return
                (wtl.getDate().compareTo(dateFrom) >= 0 && wtl.getDate().compareTo(dateTo) <= 0) &&
                        this.service.includes(wtl.getService()) &&
                        this.question.includes(wtl.getQuestion()) &&
                        this.responseType == wtl.getResponseType();
    }


}