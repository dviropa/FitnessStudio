package gym.management.Secretary.notifications;

import gym.customers.Client;
import gym.management.Gym;

 class SendNotificationsToAll {
    protected static void SendAllClientNotifications(String messege){
        for(Client c : Gym.getInstance().getClient()){
            c.addNotification(messege);
        }
    }
    public static void notify(String s) {

        SendAllClientNotifications(s);
        NotificationsManager.addNotification("A message was sent to all gym clients: Happy New Year to all our valued clients!");

    }
}
