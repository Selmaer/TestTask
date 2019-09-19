package Task.Input;

import Task.Exceptions.OutOfTaskConditionsException;

public class InputLine {
    private String definingChar;
    private String serviceStr;
    private String questionStr;
    private String responseType;
    private String date;
    private String time;

    public InputLine(String line) throws OutOfTaskConditionsException {
        String[] lineArray;
        try {
            lineArray = line.split(" ");
            definingChar = lineArray[0];
            serviceStr = lineArray[1];
            questionStr = lineArray[2];
            responseType = lineArray[3];
            date = lineArray[4];
        } catch (Exception e) {
            throw new OutOfTaskConditionsException();
        }
        try {
            time = lineArray[5];
        } catch (ArrayIndexOutOfBoundsException e) {
            time = null;
        }
    }

    public String getDefiningChar() {
        return definingChar;
    }

    public String getServiceStr() {
        return serviceStr;
    }

    public String getQuestionStr() {
        return questionStr;
    }

    public String getResponseType() {
        return responseType;
    }

    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }
}
