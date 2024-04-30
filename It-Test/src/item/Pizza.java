package item;

public class Pizza extends Item{
    public Pizza() {
        super(4.5);
    }

    @Override
    protected void gift() {

    }

    @Override
    public String toString() {
        return "Pizza{" +
                "price=" + price +
                '}';
    }
}
