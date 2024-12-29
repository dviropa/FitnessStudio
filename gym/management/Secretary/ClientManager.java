package gym.management.Secretary;

import gym.Exception.ClientNotRegisteredException;
import gym.Exception.DuplicateClientException;
import gym.Exception.InvalidAgeException;
import gym.customers.Client;
import gym.customers.person.Person;
import gym.management.Gym;
import gym.management.Secretary.notifications.NotificationsManager;

// פונקציות של המזכירה שכך היא מנהלת את הג'ים ובהתאם לפונקציות גם מודפס ונזרקות שגיאות בהתאם לדרישות המטלה
class ClientManager {
     protected static Client registerClient(Person p2) throws DuplicateClientException, InvalidAgeException {
        Gym gym = Gym.getInstance();
        if(gym.getClient()!=null){
            if (contains(p2)){
                throw new DuplicateClientException("Error: The client is already registered");
            }
            else if (p2.getage() >17)
            {
                Client c = new Client(p2);
                gym.registerClient(c);
                NotificationsManager.addNotification("Registered new client: "+p2.getName()+"");
                return c;
            }
            else {
                throw new InvalidAgeException("Error: Client must be at least 18 years old to register");
            }
        }
        else if (p2.getage() >17)
         {
            Client c = new Client(p2);
            gym.registerClient(c);
            NotificationsManager.addNotification("Registered new client: "+p2.getName()+"");
            return c;
        }
        else {
            throw new InvalidAgeException("Error: Client must be at least 18 years old to register");
        }
    }
    protected static Client unRegisterClient(Client c) throws ClientNotRegisteredException {

        Gym gym = Gym.getInstance();
        for (Client cl : gym.getClient()) {
            if (cl.equals(c)) {
                gym.unRegisterClient(cl);
                NotificationsManager.addNotification("Unregistered client: "+c.getName()+"");
                return cl;
                //מחיקת הלקוח מהשיעורים שהוא רשום אליהם
            }

        }
        throw new ClientNotRegisteredException("Error: Registration is required before attempting to unregister");

    }
      protected static boolean contains(Person p) {
         Gym gym = Gym.getInstance();
         if (p == null) return false; // בדיקה לסוג האובייקט
        for (Client c:gym.getClient()){
            if( c.getid() == p.getid())return true; // לדוגמה, השוואה לפי מאפיין מזהה ייחודי
        }

return false;

     }

 }
