package gym.management.Secretary.notifications;

import gym.DateUtils;
import gym.customers.Client;
import gym.management.Gym;
import gym.management.Sessions.Session;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

class DateNotification  {
    public static void notify(String date, String s1) {
        SendAllClientotifications(date, s1);
        NotificationsManager.addNotification("A message was sent to everyone registered for a session on " + formatDateTime(date) + " : Heavy traffic reported around the gym today. Plan ahead to avoid missing your session!");

    }
    private static void SendAllClientotifications(String date, String messege){
        for(Session s : Gym.getInstance().getSessions()){
            if(isSameDay(s.getDatetime(),date))
                for(Client c :s.getListOfClients()){
                    c.addNotification(messege);
                }
        }
    }
    protected static boolean isSameDay(String date1, String date2) {
        return DateUtils.isSameDay(date1,date2);
//        // פורמטים לתאריך עם וללא שעה
//        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
//        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
//
//        // המרה ל-LocalDate תוך בדיקת סוג הפורמט
//        LocalDate localDate1 = parseDate(date1, dateTimeFormatter, dateFormatter);
//        LocalDate localDate2 = parseDate(date2, dateTimeFormatter, dateFormatter);
//
//        // השוואת התאריכים
//        return localDate1.equals(localDate2);
    }
    public static String formatDateTime(String inputDate) {
//        // פורמט לתאריך בלבד
//        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
//        // פורמט הפלט
//        DateTimeFormatter outputFormatterDateOnly = DateTimeFormatter.ofPattern("yyyy-MM-dd");
//        try {
//            // ניסיון לפרמט תאריך בלבד
//            LocalDate date = LocalDate.parse(inputDate, dateFormatter);
//            return date.format(outputFormatterDateOnly);
//        } catch (DateTimeParseException e2) {
//            // אם הפורמט לא תקין, מחזירים את הקלט המקורי
//            return inputDate;
//        }
        return DateUtils.formatDateTime(inputDate);
    }

}
