package gym.management.Secretary;

import gym.Exception.ClientNotRegisteredException;
import gym.Exception.DuplicateClientException;
import gym.Exception.InstructorNotQualifiedException;
import gym.customers.Client;
import gym.customers.Instructor;
import gym.customers.person.Gender;
import gym.management.Gym;
import gym.management.Sessions.ForumType;
import gym.management.Sessions.Session;
import gym.management.Sessions.SessionFactory;
import gym.management.Sessions.SessionType;
import gym.management.Secretary.notifications.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

// פונקציות של המזכירה שכך היא מנהלת את הג'ים ובהתאם לפונקציות גם מודפס ונזרקות שגיאות בהתאם לדרישות המטלה
public class LessonManager {
    protected static void registerClientToLesson(Client c1, Session s1) throws DuplicateClientException, ClientNotRegisteredException {

        Gym gym = Gym.getInstance();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm");
        Date currentDate = new Date();
        try {
            int chekall = 0;
            // המרת ה-String לתאריך
            Date date = dateFormat.parse(s1.getDatetime());
            if (s1.getListOfClients().contains(c1)) {
                throw new DuplicateClientException("Error: The client is already registered for this lesson");
            } else if (!gym.getClient().contains(c1)) {
                throw new ClientNotRegisteredException("Error: The client is not registered with the gym and cannot enroll in lessons");
            } else {
                if (currentDate.before(date)) chekall++;
                else {
                    NotificationsManager.addNotification("Failed registration: Session is not in the future");
                }
                if (isLessongetForumTypeSuitableForClient(s1, c1)) chekall++;// השיעור מתאים אליו  מין..
                else {
                    NotificationsManager.addNotification("Failed registration: Client's gender doesn't match the session's gender requirements");
                }
                if (isLessongetAgeSuitableForClient(s1, c1)) chekall++;//השיעור מתאים אליו גיל ..
                else {
                    NotificationsManager.addNotification("Failed registration: Client doesn't meet the age requirements for this session (Seniors)");
                }
                if (s1.getAvailablePlaces() > 0) chekall++;      //יש מקומות פנויים
                else {
                    NotificationsManager.addNotification("Failed registration: No available spots for session");
                }
                if (s1.getprice() <= c1.getAccountBalanc()) chekall++;     //יש ללקוח מספיק כסף
                else {
                    NotificationsManager.addNotification("Failed registration: Client doesn't have enough balance");
                }
                if (chekall == 5) {
                    s1.addClientToList(c1);
                    c1.updateAccountBalanc(c1.getAccountBalanc() - s1.getprice()); // הורדת הכסף שך השיעור מהסכום שיש ללקוח

                    gym.addMoney(s1.getprice()); // הוספת הכסף לקופת המכון

                    DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");

                    // יצירת אובייקט LocalDateTime מתוך התאריך הנתון
                    LocalDateTime dateTime = LocalDateTime.parse(s1.getDatetime(), inputFormatter);

                    // הפורמט הרצוי: "2024-12-23T10:00"
                    String formattedDate = dateTime.toString();
                    NotificationsManager.addNotification("Registered client: " + c1.getName() + " to session: " + s1.getSessionType().toString() + " on " + formattedDate + " for price: " + s1.getprice() + "");
                }
            }
        } catch (ParseException e) {
            System.out.println("שגיאה בהמרת התאריך: " + e.getMessage());
        }
    }


    protected static boolean isLessongetForumTypeSuitableForClient(Session session, Client client) {
        if (session.getForumType() == ForumType.All) return true;
        if (session.getForumType() == ForumType.Seniors) return true;
        if (equals(session, client)) return true;

        return false;
    }

    protected static boolean equals(Session session, Client client) {
        if (session.getForumType().equals(ForumType.Male) && client.getGender() == Gender.Male) return true;
        if (session.getForumType().equals(ForumType.Female) && client.getGender().equals(Gender.Female)) return true;
        return false;
    }

    protected static boolean isLessongetAgeSuitableForClient(Session session, Client client) {
        if (session.getForumType() == ForumType.All) return true;
        if (session.getForumType() == ForumType.Seniors && client.getage() > 64) return true;
        if ((session.getForumType() != ForumType.Seniors && client.getage() > 17)) return true;
        return false;
    }

    protected static Session addSession(SessionType sessionType, String datetime, ForumType forumType, Instructor instructor) throws InstructorNotQualifiedException {


        if (!instructor.getListOfSkills().contains(sessionType)) {

            throw new InstructorNotQualifiedException("Error: Instructor is not qualified to conduct this session type.");

        }
        Session session = SessionFactory.createSession(sessionType, datetime, forumType, instructor);
        Gym.getInstance().addSession(session);


        DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
        // יצירת אובייקט LocalDateTime מתוך התאריך הנתון
        LocalDateTime dateTime = LocalDateTime.parse(datetime, inputFormatter);

        // הפורמט הרצוי: "2024-12-23T10:00"
        String formattedDate = dateTime.toString();
        NotificationsManager.addNotification("Created new session: " + sessionType.toString() + " on " + formattedDate + " with instructor: " + instructor.getName() + "");
        return session;

    }

}
