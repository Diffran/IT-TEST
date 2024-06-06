package order;


import product.Product;
import person.Client;
import person.Delivery;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private static int lastOrderID;
    private final int ID;
    private Client client;
    private Delivery delivery;
    private List<Product> products = new ArrayList<Product>();
    private double price;
    private DeliveryType deliveryType;

//Order falta enum per calcular com va el repartidor
    public Order(Client client, Delivery delivery, List<Product> products, DeliveryType deliveryType) {
        lastOrderID++;
        this.ID = lastOrderID;
        this.client = client;
        this.delivery = delivery;
        this.products = products;
        price = finalPrice(deliveryType.getVALUE());
    }


    private double finalPrice(double deliveryType){
        double price=0;
        for(Product product : products){
            price += product.getPrice();
        }
        price = price + price*deliveryType;
        return price;
    }
    private String productsToString(){
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < products.size(); i++) {
            stringBuilder.append(products.get(i).toString());
            if (i < products.size() - 1) {
                stringBuilder.append("\n");
            }
        }
        return stringBuilder.toString();
    }

    @Override
    public String toString(){
        return "ID: "+ID+"\n"+client+"\n"+delivery+"\nItems:\n"+productsToString()+"\n"+deliveryType+"\nTotal: "+price+"\n----------------------------";
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

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
