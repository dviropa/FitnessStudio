package gym.management.Sessions;

import gym.customers.Client;
import gym.customers.Instructor;

import java.util.ArrayList;
import java.util.List;

public interface Session {
    // קבלת סוג הסשן
    SessionType getSessionType();

    // קבלת סוג הפורום
    ForumType getForumType();

    // קבלת תאריך ושעה של הסשן
    String getDatetime();

    default String ToString() {
        int sum=this.getAvailablePlaces()+this.getnumofprticipats();
        return  ("Session Type: "+this.getSessionType()+" | Date: "+this.getDatetime()+" | Forum: "+this.getForumType()+" | Instructor: "+this.getInstructor().getName()+" | Participants: "+this.getnumofprticipats()+"/"+sum+"");

    }

    // קבלת המדריך שמוביל את הסשן
    Instructor getInstructor();

    // הוספת לקוח לרשימת המשתתפים
    boolean addClientToList(Client client);

    // קבלת המחיר של הסשן
    int getprice();

    // קבלת מספר המקומות הפנויים
    int getAvailablePlaces();

    int getnumofprticipats();

    List<Client> getListOfClients();

}























//public class Session {
//    private SessionType sessionType ;
//    private ForumType forumType;
//    private String datetime;
//    private Instructor i;
//    private int numofprticipats;
//    private int price;
//    ////ךשים את זה בכל השאר
//    private ArrayList<Client> l;
//
//
//    public ArrayList<Client> getClinetSessionList(){
//        return l;
//    }
//    public  Session(SessionType sessionType, String datetime, ForumType forumType, Instructor i){
//        this.forumType=forumType;
//        this. i= i;
//        this.datetime=datetime;
//        this.sessionType=sessionType;
//        this.numofprticipats = sessionType.getMaxParticipants();
//        this.price = sessionType.getPrice();
//    }
//
//    public void addClientToList(Client t){
//        if(l.size()<=numofprticipats)
//            l.add(t);
//    }
//    public ArrayList<Client>  getListOfClients(){
//        return l;
//    }
//
//
//
//
//
//    public SessionType getSessionType() {
//        return sessionType;
//    }
//
//
//    public ForumType getForumType() {
//        return forumType;
//    }
//
//
//    public String getDatetime() {
//        return datetime;
//    }
//
//    public Instructor getInstructor() {
//        return i;
//    }
//
//
//    public void setSessionType(SessionType t) {
//        this.sessionType=t;
//    }
//
//    public void setInstructor(Instructor i) {
//        this.i=i;
//    }
//
//
//    public void setForumType(ForumType f) {
//        forumType=f;
//    }
//
//
//    public void setDatetime(String d) {
//        datetime=d;
//    }
//
//
//    public String getdatetime() {
//        return datetime;
//    }
//
//    public int getprice(){
//        return price;
//    }
//    public int getnumofprticipats(){
//        return numofprticipats;
//    }
//    public void updateAvailablePlaces(){
//        numofprticipats--;
//    }
//}

//public interface Session {
//
//
//
//    SessionType getSessionType();
//    ForumType getForumType();
//    String getDatetime();
//    Instructor getInstructor();
//    void Session(SessionType sessionType,String datetime ,ForumType forumType ,Instructor i);
//
//    int getnumofprticipats();
//    int getprice();
//
//    public void removeprticipat();
//    void setSessionType(SessionType t);
//    void setForumType(ForumType f);
//    void setDatetime(String d);
//    void setInstructor(Instructor i);
//
//
//     ArrayList<Client> getList();
//     void add(Client t);
//      String getdatetime();
//}
/*
public class Session {
    //        Session s1 = gymSecretary.addSession(SessionType.Pilates, "23-12-2024 10:00", ForumType.All, i2);
    private SessionType sessionType;
    private ForumType forumType;
    private String datetime;
    public SessionType getSessionType(){
        return sessionType;
    }
    public ForumType getForumType(){
        return forumType;
    }
    public String getdatetime(){
        return datetime;
    }

    public void SetSessionType(SessionType t){
        this.sessionType=t;
    }
    public void SetForumType(ForumType f){
        this.forumType=f;
    }
    public void Setdatetime(String d){
        this.datetime=d;
    }

public Instructor i;
}

 */