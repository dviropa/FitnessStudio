package gym.management.Secretary;

import gym.management.Gym;
import gym.management.Secretary.notifications.NotificationsManager;
import gym.management.Sessions.Session;

public class SalariesManager {
    public static void paySalaries() {
        Gym gym = Gym.getInstance();
        payInstructor( gym);
        paySecretary( gym);
        NotificationsManager.addNotification("Salaries have been paid to all employees");

    }
    public static void paySecretary(Gym gym) {
        gym.getSecretary().updateAccountBalanc(gym.getSecretary().getAccountBalanc() + gym.getSecretary().getSalary());
        gym.reduceMoney(gym.getSecretary().getSalary());
    }
    public static void payInstructor(Gym gym) {
        for (Session session : gym.getSessions()) {
            session.getInstructor().updateAccountBalanc(session.getInstructor().getAccountBalanc() + session.getInstructor().getSalaryForSession());
            gym.reduceMoney(session.getInstructor().getSalaryForSession());
        }
    }
}
