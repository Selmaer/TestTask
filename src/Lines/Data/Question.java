package Lines.Data;

import Lines.Conditions.TaskConditions;
import Lines.Exceptions.OutOfTaskConditionsException;

public class Question {
    private Boolean allOfTheQuestions;
    private Integer questionTypeId;
    private Integer categoryId;
    private Integer subCategoryId;

    public Question(String questionData) throws OutOfTaskConditionsException {
        String[] qd = questionData.split(".");

        if (qd.length > 0) {
            if (qd[0] == "*") {
                allOfTheQuestions = true;
            } else {
                questionTypeId = validate(qd[0], TaskConditions.QUESTION_TYPES);
            }
        }
        if (qd.length > 1) {
            categoryId = validate(qd[1], TaskConditions.CATEGORIES_AMOUNT);
        }
        if (qd.length > 2) {
            subCategoryId = validate(qd[2], TaskConditions.SUB_CATEGORIES_AMOUNT);
        }
    }

    private static int validate(String inputData, int condition) throws OutOfTaskConditionsException {
        int input = Integer.parseInt(inputData);

        if (input > 0 && input <= condition) {
            return input;
        } else {
            throw new OutOfTaskConditionsException();
        }
    }

    public Boolean getAllOfTheQuestions() {
        return allOfTheQuestions;
    }

    public Integer getQuestionTypeId() {
        return questionTypeId;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public Integer getSubCategoryId() {
        return subCategoryId;
    }
}
