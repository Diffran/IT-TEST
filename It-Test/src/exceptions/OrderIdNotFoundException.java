package exceptions;

public class OrderIdNotFoundException extends Exception{
    public OrderIdNotFoundException() {
        super("ERROR: order ID not found");
    }
}
