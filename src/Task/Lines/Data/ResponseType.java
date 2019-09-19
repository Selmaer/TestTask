package Task.Lines.Data;

import Task.Exceptions.OutOfTaskConditionsException;

public enum ResponseType {
    FIRST_ANSWER,
    NEXT_ANSWER;

    public static ResponseType set(String letter) throws OutOfTaskConditionsException {
        if (letter.equals("P")) {
            return ResponseType.FIRST_ANSWER;
        } else if (letter.equals("N")) {
            return ResponseType.NEXT_ANSWER;
        } else {
            throw new OutOfTaskConditionsException();
        }
    }
}
