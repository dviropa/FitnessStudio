package gym.management.Secretary.notifications;
import gym.management.Sessions.Session;
public class Notifications {

    // התראה לclass המתאים לה
    public static void notify(Session s4, String s) {
        SessionNotification.notify( s4,  s);
    }
     public static void notify(String s) {
         SendNotificationsToAll.notify( s);
    }

    public static void notify(String date, String s1) {
        DateNotification.notify( date,  s1);
    }

}





























//     protected void SendAllClientNotifications(String messege){
//        for(Client c : Gym.getInstance().getClient()){
//            c.addNotification(messege);
//        }
//    }
//     protected void SendNotificationsPerSession(Session session , String messege){
//        for(Session s : Gym.getInstance().getSessions()){
//            if(s.getSessionType().equals(session.getSessionType()))
//                for(Client c :s.getListOfClients()){
//                    c.addNotification(messege);
//                }
//        }
//    }
//     protected void SendAllClientotifications(String date,  String messege){
//        for(Session s : Gym.getInstance().getSessions()){
//            if(isSameDay(s.getDatetime(),date))
//                for(Client c :s.getListOfClients()){
//                    c.addNotification(messege);
//                }
//        }
//    }
//
//     protected static boolean isSameDay(String date1, String date2) {
//            // פורמטים לתאריך עם וללא שעה
//            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
//            DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
//
//            // המרה ל-LocalDate תוך בדיקת סוג הפורמט
//            LocalDate localDate1 = parseDate(date1, dateTimeFormatter, dateFormatter);
//            LocalDate localDate2 = parseDate(date2, dateTimeFormatter, dateFormatter);
//
//            // השוואת התאריכים
//            return localDate1.equals(localDate2);
//        }
//
//     protected static void notify(Session s4, String s) {
//        Notifications notifications = new Notifications();
//        notifications.SendNotificationsPerSession(s4, s);
//        //  System.out.println("A message was sent to everyone registered for session " + s4.getSessionType() + " on " + converttimeformat(s4) + " : The instructor will be a few minutes late for the session\n");
//        NotificationsManager.addNotification("A message was sent to everyone registered for session " + s4.getSessionType() + " on " + converttimeformat(s4) + " : The instructor will be a few minutes late for the session");
//
//    }
//
//     protected static void notify(String s) {
//
//        Notifications notifications = new Notifications();
//        notifications.SendAllClientNotifications(s);
//        //  System.out.println("A message was sent to all gym clients: Happy New Year to all our valued clients!\n");
//        NotificationsManager.addNotification("A message was sent to all gym clients: Happy New Year to all our valued clients!");
//
//    }
//
//     protected static void notify(String date, String s1) {
//
//        Notifications notifications = new Notifications();
//        notifications.SendAllClientotifications(date, s1);
//        // System.out.println("A message was sent to everyone registered for a session on " + date + " : Heavy traffic reported around the gym today. Plan ahead to avoid missing your session!\n");
//        NotificationsManager.addNotification("A message was sent to everyone registered for a session on " + formatDateTime(date) + " : Heavy traffic reported around the gym today. Plan ahead to avoid missing your session!");
//
//    }
//
//     protected static LocalDate parseDate(String date, DateTimeFormatter dateTimeFormatter, DateTimeFormatter dateFormatter) {
//            try {
//                // נסה תחילה לפרש כתאריך עם שעה
//                return LocalDateTime.parse(date, dateTimeFormatter).toLocalDate();
//            } catch (Exception e) {
//                // אם נכשל, נסה לפרש כתאריך בלבד
//                return LocalDate.parse(date, dateFormatter);
//            }
//        }
//
//     protected static String converttimeformat(Session s1){
//        DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
//
//        // יצירת אובייקט LocalDateTime מתוך התאריך הנתון
//        LocalDateTime dateTime = LocalDateTime.parse(s1.getDatetime(), inputFormatter);
//
//        // הפורמט הרצוי: "2024-12-23T10:00"
//        return   dateTime.toString();
//    }
//    public static String formatDateTime(String inputDate) {
//        // פורמט לתאריך בלבד
//        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
//        // פורמט הפלט
//        DateTimeFormatter outputFormatterDateOnly = DateTimeFormatter.ofPattern("yyyy-MM-dd");
//
//
//            try {
//                // ניסיון לפרמט תאריך בלבד
//                LocalDate date = LocalDate.parse(inputDate, dateFormatter);
//                return date.format(outputFormatterDateOnly);
//            } catch (DateTimeParseException e2) {
//                // אם הפורמט לא תקין, מחזירים את הקלט המקורי
//                return inputDate;
//            }
//        }
