package exceptions;

public class NoIDException extends Exception{
    public NoIDException() {
        super("ERROR: order ID not found");
    }
}
