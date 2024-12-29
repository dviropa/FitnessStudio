package gym;

import gym.management.Sessions.Session;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;


// מחלקה שמטפלת בתאריכים, עשינו זאת כך על מנת שיהיה לנו סדר
public class DateUtils {

    // מחשבת גיל לפי תאריך לידה
    public static int calculateAge(String birthDateString) {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
            LocalDate birthDate = LocalDate.parse(birthDateString, formatter);
            LocalDate currentDate = LocalDate.now();
            return Period.between(birthDate, currentDate).getYears();
        } catch (DateTimeParseException e) {
            System.out.println("Invalid date format: " + birthDateString);
            return -1; // ערך שמציין שגיאה
        }
    }

    // בודקת אם שני תאריכים הם באותו יום
    public static boolean isSameDay(String date1, String date2) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        LocalDate localDate1 = parseDate(date1, dateTimeFormatter, dateFormatter);
        LocalDate localDate2 = parseDate(date2, dateTimeFormatter, dateFormatter);

        return localDate1.equals(localDate2);
    }

    // ממירה תאריך לפורמט אחר
    public static String formatDateTime(String inputDate) {
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        DateTimeFormatter outputFormatterDateOnly = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        try {
            LocalDate date = LocalDate.parse(inputDate, dateFormatter);
            return date.format(outputFormatterDateOnly);
        } catch (DateTimeParseException e) {
            return inputDate; // אם הפורמט לא תקין, מחזירים את הקלט המקורי
        }
    }

    // ממירה תאריך ושעה לפורמט LocalDateTime
    public static LocalDateTime parseToLocalDateTime(String dateTimeString, String pattern) {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
            return LocalDateTime.parse(dateTimeString, formatter);
        } catch (DateTimeParseException e) {
            System.out.println("Invalid date-time format: " + dateTimeString);
            return null; // ערך שמציין שגיאה
        }
    }

    // פונקציה עזר להמרת תאריכים
    public static LocalDate parseDate(String date, DateTimeFormatter dateTimeFormatter, DateTimeFormatter dateFormatter) {
        try {
            return LocalDateTime.parse(date, dateTimeFormatter).toLocalDate();
        } catch (Exception e) {
            return LocalDate.parse(date, dateFormatter);
        }
    }

    // ממירה זמן מפורמט אחד לאחר עבור Session
    public static String convertTimeFormat(String dateTime, String inputPattern, String outputPattern) {
        DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern(inputPattern);
        DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern(outputPattern);
        try {
            LocalDateTime parsedDateTime = LocalDateTime.parse(dateTime, inputFormatter);
            return parsedDateTime.format(outputFormatter);
        } catch (DateTimeParseException e) {
            System.out.println("Invalid date-time format: " + dateTime);
            return dateTime; // אם יש שגיאה, מחזירים את הקלט המקורי
        }
    }

    // ממירה תאריך ושעה לפורמט סטנדרטי של LocalDateTime
    public static String convertTimeFormat(Session session) {
        DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
        LocalDateTime dateTime = LocalDateTime.parse(session.getDatetime(), inputFormatter);
        return dateTime.toString();
    }
}

