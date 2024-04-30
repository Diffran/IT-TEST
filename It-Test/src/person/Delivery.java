package person;

public class Delivery extends Person{
    private boolean available;

    public Delivery(String name) {
        super(name);
        this.available = false;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }
    @Override
    public String toString(){
        return "Delivery: "+ name +" Available: "+available;
    }
}
