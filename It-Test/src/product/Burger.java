package product;


public class Burger extends Product{

    private static final double PRICE = 8.9;
    public Burger() {
        super(PRICE);
        gift();
    }

    @Override
    public void gift(){
        System.out.println("you receive a gift: A CAP");
    }
    @Override
    public String toString() {
        return "Burger{" +
                "price=" + price +
                '}';
    }
}
