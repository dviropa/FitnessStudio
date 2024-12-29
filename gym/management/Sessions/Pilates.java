package gym.management.Sessions;

import gym.customers.Client;
import gym.customers.Instructor;

import java.util.ArrayList;
import java.util.List;

public class Pilates implements Session {
    private SessionType sessionType;
    private ForumType forumType;
    private String datetime;
    private Instructor instructor;
    private int maxParticipants;
    private int price;
    private ArrayList<Client> clients;

    public Pilates(SessionType sessionType, String datetime, ForumType forumType, Instructor instructor) {
        this.sessionType = SessionType.Pilates;
        this.datetime = datetime;
        this.forumType = forumType;
        this.instructor = instructor;
        this.maxParticipants = sessionType.getMaxParticipants();
        this.price = sessionType.getPrice();
        this.clients = new ArrayList<>();
    }


    @Override
    public SessionType getSessionType() {
        return sessionType;
    }

    @Override
    public ForumType getForumType() {
        return forumType;
    }
    @Override
    public String getDatetime() {
        return datetime;
    }

    @Override
    public Instructor getInstructor() {
        return instructor;
    }

    @Override
    public boolean addClientToList(Client client) {
        if (clients.size() < maxParticipants) {
            clients.add(client);
            return true;
        }
        return false;
    }

    @Override
    public int getprice() {
        return price;
    }

    @Override
    public int getAvailablePlaces() {
        return maxParticipants - clients.size();
    }


    public void setInstructor(Instructor i) {
        this.instructor=i;
    }


    public void setForumType(ForumType f) {
        forumType=f;
    }


    public void setDatetime(String d) {
        datetime=d;
    }



    public int getnumofprticipats(){
        return clients.size();
    }

    @Override
    public List<Client> getListOfClients() {
        return clients;
    }



}

