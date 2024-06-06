package order;


import product.Product;
import person.Client;
import person.Delivery;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Order {
    private static int lastOrderID;
    private final int IdOrder;
    private Client client;
    private Delivery delivery;
    private List<Product> products = new ArrayList<Product>();
    private double price;
    private DeliveryType deliveryType;

//Order falta enum per calcular com va el repartidor
    public Order(Client client, Delivery delivery, List<Product> products) {
        lastOrderID++;
        this.IdOrder = lastOrderID;
        this.client = client;
        this.delivery = delivery;
        this.products = products;
        price = finalPrice(delivery.getDeliveryType().getVALUE());
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
        return String.join("\n", products.stream()
                .map(Object::toString)
                .collect(Collectors.toList()));
    }

    @Override
    public String toString(){
        return "ID: "+ IdOrder +"\n"+client+"\n"+delivery+"\nItems:\n"+productsToString()+"\n"+deliveryType+"\nTotal: "
                +price+"\n----------------------------";
    }

    //GETTER I SETTER
    public int getIdOrder() {
        return IdOrder;
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
