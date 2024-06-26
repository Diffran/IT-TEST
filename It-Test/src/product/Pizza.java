package product;


public class Pizza extends Product{

    private static final double PRICE = 4.5;

    public Pizza() {
        super(PRICE);
    }

    @Override
    protected void gift() {
        System.out.println("No gift with this Item");
    }

    @Override
    public String toString() {
        return "Pizza{" +
                "price=" + price +
                '}';
    }
}
