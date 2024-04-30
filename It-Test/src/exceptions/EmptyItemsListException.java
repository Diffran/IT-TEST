package exceptions;

public class EmptyItemsListException extends Exception{
    public EmptyItemsListException() {
        super("ERROR: Item List must not be empty");
    }
}
