package gym.management.Secretary.notifications;

import gym.DateUtils;
import gym.customers.Client;
import gym.management.Gym;
import gym.management.Sessions.Session;


class SessionNotification  {

    protected static void SendNotificationsPerSession(Session session, String messege){
        for(Session s : Gym.getInstance().getSessions()){
            if(s.getSessionType().equals(session.getSessionType()))
                for(Client c :s.getListOfClients()){
                    c.addNotification(messege);
                }
        }
    }
    public static void notify(Session s4, String s) {
        SendNotificationsPerSession(s4, s);
        NotificationsManager.addNotification("A message was sent to everyone registered for session " + s4.getSessionType() + " on " + converttimeformat(s4) + " : The instructor will be a few minutes late for the session");

    }
    protected static String converttimeformat(Session s1){
        return DateUtils.convertTimeFormat(s1);
//        DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
//
//        // יצירת אובייקט LocalDateTime מתוך התאריך הנתון
//        LocalDateTime dateTime = LocalDateTime.parse(s1.getDatetime(), inputFormatter);
//
//        // הפורמט הרצוי: "2024-12-23T10:00"
//        return   dateTime.toString();
    }
}
