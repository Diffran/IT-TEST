package item;

public abstract class Item {
    protected double price;

    public Item(double price) {
        this.price = price;
    }
    protected abstract void gift();

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
