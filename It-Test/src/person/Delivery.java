package person;

import order.DeliveryType;

public class Delivery extends Person{
    private boolean available;
    private DeliveryType deliveryType;

    public Delivery(String name, DeliveryType deliveryType) {
        super(name);
        this.available = true;
        this.deliveryType = deliveryType;
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

    public DeliveryType getDeliveryType() {
        return deliveryType;
    }

    public void setDeliveryType(DeliveryType deliveryType) {
        this.deliveryType = deliveryType;
    }
}
