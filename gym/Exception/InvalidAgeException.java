package gym.Exception;
public class InvalidAgeException extends Exception{
    public String getMessage() {
        return super.getMessage();
    }
    public InvalidAgeException(String message) {
        super(message);
    }
}
