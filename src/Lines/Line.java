package Lines;

import Lines.Data.Question;
import Lines.Data.ResponseType;
import Lines.Data.Service;

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
