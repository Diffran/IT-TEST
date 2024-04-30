package item;

public class Burger extends Item{
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
