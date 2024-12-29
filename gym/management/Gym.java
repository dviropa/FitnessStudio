package gym.management;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import gym.customers.Client;
import gym.customers.Instructor;
import gym.customers.person.Person;
import gym.management.Secretary.Secretary;
import gym.management.Sessions.*;

public class Gym {
    private static Gym instance; // מופע סטטי יחיד
    private Secretary secretary;
    private String name;
    private int balance;
    private List<Client> clients;
    private List<Instructor> Instructors;
    private List<Session> Session;

    private ArrayList<String> GymNotifications;

    // קונסטרקטור פרטי כדי למנוע יצירת מופע חדש מחוץ למחלקה
    private Gym() {
        this.clients = new ArrayList<>();
        this.Instructors = new ArrayList<>();
        this.Session = new ArrayList<>();
        GymNotifications = new ArrayList<>();
        this.balance = 0;
    }


    // שיטה סטטית ליצירת המופע היחיד
    public static Gym getInstance() {
        if (instance == null) { // יצירה עצלה (Lazy Initialization)
            instance = new Gym();
        }
        return instance;
    }

    public void setName(String crossFit) {
        name = crossFit;
    }

    public String getName() {
        return name;
    }

    public int getBalance() {
        return balance;
    }

    public void addMoney(int x) {
        balance += x;
    }

    public void reduceMoney(int x) {
        balance -= x;
    }

    public void setSecretary(Person p1, int i) {

        if (secretary == null) { // ודא שמזכירה כבר קיימת
            secretary = new Secretary(p1, i);
            GymNotifications().add("A new secretary has started working at the gym: " + p1.getName() + "");

        } else if (secretary.getid() == p1.getid()) {
            if (secretary.getAccountBalanc() != i) secretary.updateAccountBalanc(i);
        } else {
            this.secretary = new Secretary(p1, i);
            GymNotifications().add("A new secretary has started working at the gym: " + p1.getName() + "");
        }

    }

    public ArrayList<String> GymNotifications() {
        return GymNotifications;
    }

    public Secretary getSecretary() {
        return secretary;
    }

    public List<Client> getClient() {
        return Collections.unmodifiableList(clients);
    }

    public List<Instructor> getInstructors() {
        return Collections.unmodifiableList(Instructors);
    }

    public List<Session> getSessions() {
        return Collections.unmodifiableList(Session);
    }


    public void registerClient(Client c) {
        this.clients.add(c);
    }

    public void unRegisterClient(Client c) {
        this.clients.remove(c);
    }

    public void hireInstructor(Instructor i) {
        this.Instructors.add(i);

    }

    public void addSession(Session session) {
        this.Session.add(session);
    }

    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append("Gym Name: " + name + "\nGym Secretary: ID: " + secretary.getid() + " | Name: " + secretary.getName() + " | Gender: " + secretary.getGender() + " | Birthday: " + secretary.getDateOfBirth() + " | Age: " + secretary.getage() + " | Balance: " + secretary.getAccountBalanc() + " | Role: Secretary | Salary per Month: " + secretary.getSalary() + "\n" +
                "Gym Balance: " + balance + "\n");
        s.append("\n");
        s.append("Clients Data:\n");
        for (Client c : getClient()) {
            s.append(c.ToString());
        }
        s.append("\n");
        s.append("Employees Data:\n");
        String temp = "";
        for (Instructor i : getInstructors()) {
            s.append(i.ToString());
        }
        s.append(secretary.ToString());
        s.append("Sessions Data:\n");
        for (int i = 0; i < getSessions().size(); i++) {
            s.append(getSessions().get(i).ToString());
            if (i != getSessions().size() - 1) { // הוספת ירידת שורה רק אם זו לא השורה האחרונה
                s.append("\n");
            }
        }

        return s.toString();
    }
}

