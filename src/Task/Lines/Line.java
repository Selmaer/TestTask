package Task.Lines;

import Task.Lines.Data.Question;
import Task.Lines.Data.ResponseType;
import Task.Lines.Data.Service;

abstract class Line {
    Service service;
    Question question;
    ResponseType responseType;

    Service getService() {
        return service;
    }

    Question getQuestion() {
        return question;
    }

    ResponseType getResponseType() {
        return responseType;
    }
}
