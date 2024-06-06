package product;

public abstract class Product {
    protected double price;

    public Product(double price) {
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
