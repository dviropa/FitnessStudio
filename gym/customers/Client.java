package gym.customers;

import gym.customers.person.Person;

import java.util.ArrayList;
import java.util.List;

public class Client extends Person implements Notifiable {
    private ArrayList<String> ClinetNotifications;

    public Client(Person p) {
        super(p);
        ClinetNotifications = new ArrayList<>();
    }

    public boolean equals(Client c) {
        if (this == c) return true; // בדיקה אם מדובר באותו אובייקט
        if (c == null) return false; // בדיקה לסוג האובייקט

        return this.getid() == c.getid(); // לדוגמה, השוואה לפי מאפיין מזהה ייחודי
    }

    public String ToString() {
        return ("ID: " + this.getid() + " | Name: " + this.getName() + " | Gender: " + this.getGender() + " | Birthday: " + this.getDateOfBirth() + " | Age: " + this.getage() + " | Balance: " + this.getAccountBalanc() + "\n");

    }

    @Override
    public List<String> getNotifications() {
        return ClinetNotifications;
    }

    public void addNotification(String s) {
        ClinetNotifications.add(s);
    }

    public int getAccountBalanc() {
        return this.getMoney();
    }

    public void updateAccountBalanc(int newSalary) {
        this.setMoney(newSalary);
    }

}
