package item;

public class Kebab extends Item{
    private static final double PRICE = 7.9;
    public Kebab() {
        super(PRICE);
    }

    @Override
    protected void gift() {
        System.out.println("No gift with this Item");
    }

    @Override
    public String toString() {
        return "Kebab{" +
                "price=" + price +
                '}';
    }
}
