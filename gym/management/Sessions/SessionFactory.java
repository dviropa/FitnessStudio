package gym.management.Sessions;

import gym.customers.Instructor;
public class SessionFactory {
    public static Session createSession(SessionType sessionType, String datetime, ForumType forumType, Instructor instructor) {
        switch (sessionType) {
            case MachinePilates -> {
                return new MachinePilates(sessionType, datetime, forumType, instructor);
            }
            case Pilates -> {
                return new Pilates(sessionType, datetime, forumType, instructor);
            }
            case Ninja -> {
                return new Ninja(sessionType, datetime, forumType, instructor);
            }
            case ThaiBoxing -> {
                return new ThaiBoxing(sessionType, datetime, forumType, instructor);
            }
            default -> {
                return null;
            }
        }
    }
}

