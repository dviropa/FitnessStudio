package gym.customers;

import java.util.ArrayList;

import gym.customers.person.Person;
import gym.management.Sessions.*;
public class Instructor extends Person implements Employable {
    private int sallaryForSession;
    private ArrayList<SessionType> listOfSkills;

    public Instructor(Person person, int sallaryForSession, ArrayList<SessionType> listOfSkills) {
        super(person);
        this.listOfSkills = listOfSkills;
        this.sallaryForSession = sallaryForSession;
    }

    public int getSalaryForSession() {
        return sallaryForSession;
    }

    public void setSalaryForSession(int salaryForSession) {
        this.sallaryForSession = salaryForSession;
    }

    public ArrayList<SessionType> getListOfSkills() {
        return listOfSkills;
    }

    public void setListOfSkills(ArrayList<SessionType> listOfSkills) {
        this.listOfSkills = listOfSkills;
    }
    @Override
    public int getSalary() {
        return sallaryForSession;
    }
    @Override
    public void setSalary(int salary) {
        sallaryForSession = salary;

    }
    public int getAccountBalanc() {
        return this.getMoney();
    }
    public void updateAccountBalanc(int newSalary) {
        this.setMoney(newSalary);
    }
    public boolean equals(Person person) {

        return person.getid() == this.getid();

    }
    public String ToString(){
        Instructor i =this;
        String temp="";
        for (SessionType skil:i.getListOfSkills()){
            temp+=skil.toString()+", ";
        }
        temp=temp.substring(0, temp.length() - 2);
        return ("ID: "+i.getid()+" | Name: "+i.getName()+" | Gender: "+i.getGender()+" | Birthday: "+i.getDateOfBirth()+" | Age: "+i.getage()+" | Balance: "+i.getAccountBalanc()+" | Role: Instructor | Salary per Hour: "+i.getSalary()+" | Certified Classes: "+temp+"\n");
    }

}