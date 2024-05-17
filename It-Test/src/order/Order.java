package order;

import item.Item;
import person.Client;
import person.Delivery;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private static int lastOrderID;
    private final int ID;
    private Client client;
    private Delivery delivery;
    private List<Item> items = new ArrayList<Item>();
    private double price;
    private DeliveryType deliveryType;

    public Order(Client client, Delivery delivery, List<Item> items, DeliveryType deliveryType) {
        this.ID = lastOrderID++;
        this.client = client;
        this.delivery = delivery;
        this.items = items;
        this.deliveryType = deliveryType;
        price=finalPrice(deliveryType.getVALUE());
    }

    private double finalPrice(double deliveryType){
        double price=0;
        for(Item item : items){
            price += item.getPrice();
        }
        price = price + price*deliveryType;
        return price;
    }
    private String itemsToString(){
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < items.size(); i++) {
            stringBuilder.append(items.get(i).toString());
            if (i < items.size() - 1) {
                stringBuilder.append("\n");
            }
        }
        return stringBuilder.toString();
    }

    @Override
    public String toString(){
        return "ID: "+ID+"\n"+client+"\n"+delivery+"\nItems:\n"+itemsToString()+"\n"+deliveryType+"\nTotal: "+price+"\n----------------------------";
    }

    //GETTER I SETTER
    public int getID() {
        return ID;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Delivery getDelivery() {
        return delivery;
    }

    public void setDelivery(Delivery delivery) {
        this.delivery = delivery;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
