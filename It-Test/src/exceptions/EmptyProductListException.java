package exceptions;

public class EmptyProductListException extends Exception{
    public EmptyProductListException() {
        super("ERROR: Item List must not be empty");
    }
}
