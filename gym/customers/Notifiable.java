package gym.customers;

import java.util.List;

public interface Notifiable {
    void addNotification(String notification);
    List<String> getNotifications();
}