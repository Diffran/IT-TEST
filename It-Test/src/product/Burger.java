package product;

public class Burger extends Product{
    public Burger() {
        super(8.9);
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
