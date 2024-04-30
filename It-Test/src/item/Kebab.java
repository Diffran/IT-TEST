package item;

public class Kebab extends Item{
    public Kebab() {
        super(7.9);
    }

    @Override
    protected void gift() {

    }

    @Override
    public String toString() {
        return "Kebab{" +
                "price=" + price +
                '}';
    }
}
