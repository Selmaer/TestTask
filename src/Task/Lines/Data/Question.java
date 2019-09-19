package Task.Lines.Data;

import Task.Exceptions.OutOfTaskConditionsException;
import Task.TaskConditions;

public class Question {
    private boolean allOfTheQuestions;
    private Integer questionTypeId;
    private Integer categoryId;
    private Integer subCategoryId;

    private static int validate(String inputData, int condition) throws OutOfTaskConditionsException {
        int input = Integer.parseInt(inputData);

        if (input > 0 && input <= condition) {
            return input;
        } else {
            throw new OutOfTaskConditionsException();
        }
    }

    public Question(String questionData) throws OutOfTaskConditionsException {
        String[] qd = questionData.split("\\.");

        if (qd.length > 0) {
            if (qd[0].equals("*")) {
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

    public boolean includes(Question other) {
        return allOfTheQuestions || (
                (questionTypeId.equals(other.questionTypeId)) &&
                        ((categoryId == null) || (categoryId.equals(other.categoryId))) &&
                        ((subCategoryId == null) || (subCategoryId.equals(other.subCategoryId)))
        );
    }
}
