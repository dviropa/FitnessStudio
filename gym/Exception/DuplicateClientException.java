package gym.Exception;

public class DuplicateClientException extends Exception{
    public String getMessage() {
        return super.getMessage();
    }
    public DuplicateClientException(String message) {
        super(message);
    }

}
