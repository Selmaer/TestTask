package Task.Lines.Data;

import java.time.LocalDate;

public class Date {

    public static LocalDate toLocalDate(String date) {
        String[] dateArr = date.split("\\.");
        return LocalDate.of(convertToInt(dateArr[2]), convertToInt(dateArr[1]), convertToInt(dateArr[0]));
    }

    private static int convertToInt(String str) {
        return Integer.parseInt(str);
    }
}
