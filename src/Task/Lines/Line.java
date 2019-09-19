package Task.Lines;

import Task.Lines.Data.Question;
import Task.Lines.Data.ResponseType;
import Task.Lines.Data.Service;

public abstract class Line {
    protected Service service;
    protected Question question;
    protected ResponseType responseType;

    public Service getService() {
        return service;
    }

    public Question getQuestion() {
        return question;
    }

    public ResponseType getResponseType() {
        return responseType;
    }
}
