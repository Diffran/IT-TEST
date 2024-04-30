package exceptions;

public class NoFreeDeliveryDriverException extends Exception{
    public NoFreeDeliveryDriverException() {
        super("There are no delivery drivers available, please wait a while");
    }
}
