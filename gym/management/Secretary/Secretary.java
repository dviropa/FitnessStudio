package gym.management.Secretary;

import gym.customers.*;
import gym.customers.Employable;
import gym.customers.person.Person;
import gym.management.Gym;
import gym.management.Sessions.*;
import gym.Exception.InvalidAgeException;
import gym.Exception.DuplicateClientException;
import gym.Exception.ClientNotRegisteredException;
import gym.Exception.InstructorNotQualifiedException;
import gym.management.Sessions.Session;
import gym.management.Sessions.SessionType;
import gym.management.Secretary.notifications.Notifications;
import gym.management.Secretary.notifications.*;

import java.util.ArrayList;


public class Secretary extends Person implements Employable {
    private int salary;

    private boolean isAuthorized() {
        // בודק שלמזכירה הנוכחית יש הרשאות
        if (this.getid() != Gym.getInstance().getSecretary().getid()) return false;
        return true;
    }

    public Secretary(Person person, int salary) {
        super(person);
        this.salary = salary;
    }

    public String ToString() {
        Secretary secretary = this;
        return ("ID: " + secretary.getid() + " | Name: " + secretary.getName() + " | Gender: " + secretary.getGender() + " | Birthday: " + secretary.getDateOfBirth() + " | Age: " + secretary.getage() + " | Balance: " + secretary.getAccountBalanc() + " | Role: Secretary | Salary per Month: " + secretary.getSalary() + "\n\n");

    }

    public Client registerClient(Person p) throws ClientNotRegisteredException, InvalidAgeException, DuplicateClientException {
        if (!isAuthorized())
            throw new NullPointerException("Error: Former secretaries are not permitted to perform actions");
        return ClientManager.registerClient(p);
    }

    public Client unregisterClient(Client c) throws ClientNotRegisteredException {
        if (!isAuthorized())
            throw new NullPointerException("Error: Former secretaries are not permitted to perform actions");
        return ClientManager.unRegisterClient(c);
    }

    public Instructor hireInstructor(Person p4, int i, ArrayList<SessionType> objects) {
        if (!isAuthorized())
            throw new NullPointerException("Error: Former secretaries are not permitted to perform actions");

        Instructor instructor = new Instructor(p4, i, objects);
        Gym.getInstance().hireInstructor(instructor);

        NotificationsManager.addNotification("Hired new instructor: " + p4.getName() + " with salary per hour: " + instructor.getSalaryForSession() + "");
        return instructor;


    }

    public void registerClientToLesson(Client c1, Session s1) throws DuplicateClientException, ClientNotRegisteredException {
        if (!isAuthorized())
            throw new NullPointerException("Error: Former secretaries are not permitted to perform actions");
        LessonManager.registerClientToLesson(c1, s1);

    }

    public void paySalaries() {
        if (!isAuthorized())
            throw new NullPointerException("Error: Former secretaries are not permitted to perform actions");
        SalariesManager.paySalaries();
    }
    public void printActions() {
        if (!isAuthorized())
            throw new NullPointerException("Error: Former secretaries are not permitted to perform actions");
        for (String s : Gym.getInstance().GymNotifications()) {
            System.out.println(s);
        }
    }

    public Session addSession(SessionType sessionType, String datetime, ForumType forumType, Instructor instructor) throws InstructorNotQualifiedException {
        if (!isAuthorized())
            throw new NullPointerException("Error: Former secretaries are not permitted to perform actions");
        return LessonManager.addSession(sessionType, datetime, forumType, instructor);
    }

    // שולח הודעה לכל הלקוחות שרשומים לשיעור
    public void notify(Session s4, String s) {
        if (!isAuthorized())
            throw new NullPointerException("Error: Former secretaries are not permitted to perform actions");
        Notifications.notify(s4, s);
    }

    // שולח הודעה לכל הלקוחות
    public void notify(String s) {
        if (!isAuthorized())
            throw new NullPointerException("Error: Former secretaries are not permitted to perform actions");
        Notifications.notify(s);
    }

    //  שולח הודעה לכל הלקוחות שרשומים לשיעור ביום ספציפי
    public void notify(String date, String s1) {
        if (!isAuthorized())
            throw new NullPointerException("Error: Former secretaries are not permitted to perform actions");
        Notifications.notify(date, s1);
    }

    @Override
    public int getSalary() {
        return salary;
    }

    @Override
    public void setSalary(int salary) {
        salary = salary;

    }

    public int getAccountBalanc() {
        return this.getMoney();
    }

    public void updateAccountBalanc(int newSalary) {
        this.setMoney(newSalary);
    }


}


