package gym.management.Secretary.notifications;

import gym.management.Gym;

  public class NotificationsManager {
      // מוסיף את ההתראה לג'ים
     public static void addNotification(String message) {
        Gym.getInstance().GymNotifications().add(message);
    }
}
