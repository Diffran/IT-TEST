package product;


public class Burrito extends Product{


    private static final double PRICE = 6.5;

    public Burrito() {
        super(PRICE);
        gift();
    }

    @Override
    public void gift(){
        System.out.println("you receive a gift: A PIN");
    }

    @Override
    public String toString() {
        return "Burrito{" +
                "price=" + price +
                '}';
    }
}
