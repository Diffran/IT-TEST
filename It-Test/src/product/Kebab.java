package product;

public class Kebab extends Product{
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
