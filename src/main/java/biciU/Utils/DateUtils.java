package biciU.Utils;

import java.time.LocalDate;

public class DateUtils{
    public static boolean isValidDate(String date) {
        try {
            LocalDate.parse(date.trim());
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
