package exceptions;

public class InvalidMenuOptionException extends Exception{
    public InvalidMenuOptionException() {
        super("ERROR: Invalid menu Option, please enter a valid Option");
    }
}
