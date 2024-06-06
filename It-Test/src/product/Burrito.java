package product;

public class Burrito extends Product{
    public Burrito() {
        super(6.5);
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
