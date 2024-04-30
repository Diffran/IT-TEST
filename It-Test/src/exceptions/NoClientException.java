package exceptions;

public class NoClientException extends Exception{
    public NoClientException() {
        super("The client doesn't exist");
    }
}
