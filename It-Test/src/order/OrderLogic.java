package order;

import exceptions.*;
import item.Item;
import menu.GUI;
import person.Client;
import person.Delivery;
import item.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class OrderLogic {
    private static Scanner sc = new Scanner(System.in);
    private static String option;
    private static Random random = new Random();

    private static Client c1 = new Client("name1", "address1");
    private static Client c2 = new Client("name2", "address2");
    private static Client c3 = new Client("name3", "address3");
    private static Client c4 = new Client("name4", "address4");
    private static Client c5 = new Client("name5", "address5");

    private static Delivery d1 = new Delivery("Dname1");
    private static Delivery d2 = new Delivery("Dname2");
    private static Delivery d3 = new Delivery("Dname3");

    private static List<Client> clients = List.of(c1,c2,c3,c4,c5);
    private static List<Delivery> deliverers = List.of(d1,d2,d3);
    private static List<Order> orders = new ArrayList<>();
    private static List<Order> deliveredOrders = new ArrayList<>();

    //---------CREATE AN ORDER------------
    public static void newOrder()throws NoClientException, InvalidMenuOptionException, NoFreeDeliveryDriverException, EmptyItemsListException {
        Delivery delivery;
        Client client;
        List<Item> items;
        DeliveryType deliveryType;

        client = pickClient();
        items = pickItemList();
        deliveryType = pickDeliveryType();
        delivery = pickDeliveryDriver();

        Order order = new Order(client,delivery,items,deliveryType);
        orders.add(order);
        System.out.println("Order completed");
    }

    private static Client pickClient() throws NoClientException{
        String name;

        System.out.println("----------CLIENT MENU---------");
        System.out.println("Choose a clients name: ");

        name = sc.nextLine();

        for(Client client : clients){
            if(client.getName().equals(name)){
                return client;
            }
        }
        throw new NoClientException();
    }
    private static Delivery pickDeliveryDriver() throws NoFreeDeliveryDriverException{
        if (deliverers.stream().allMatch(delivery -> !delivery.isAvailable())) {
            throw new NoFreeDeliveryDriverException();
        }

        int randomIndex = random.nextInt(deliverers.size());
        boolean free = false;
        do{
            if(deliverers.get(randomIndex).isAvailable()){
                free = true;
                deliverers.get(randomIndex).setAvailable(false);
                return deliverers.get(randomIndex);
            }
            randomIndex = random.nextInt(deliverers.size());
        }while(!free);
        return null;
    }
    private static List<Item> pickItemList() throws InvalidMenuOptionException, EmptyItemsListException{
        List<Item> items =new ArrayList<Item>();
        do {
            System.out.println("-----------ITEM LIST----------------");
            System.out.println("1- Choose an item");
            System.out.println("2- Complete Order");

            option = sc.nextLine();

            switch (option) {
                case "1":
                    items.add(pickItem());
                    option=""; //if option 2 is chosen as an item it will break the loop
                    break;
                case "2":
                    break;
                default:
                    throw new InvalidMenuOptionException();
            }
        }while(!option.equals("2"));

        if(items.isEmpty()){
            throw new EmptyItemsListException();
        }
        return items;
    }
    private static Item pickItem() throws InvalidMenuOptionException{
        System.out.println("-------------ITEM-------------");
        System.out.println("1- BURRITO");
        System.out.println("2- BURGER");
        System.out.println("3- KEBAB");
        System.out.println("4- PIZZA");

        option = sc.nextLine();

        switch (option) {
            case "1":
                return new Burrito();
            case "2":
                return new Burger();
            case "3":
                return new Kebab();
            case "4":
                return new Pizza();
            default:
                throw new InvalidMenuOptionException();
        }
    }
    private static DeliveryType pickDeliveryType() throws InvalidMenuOptionException{
        System.out.println("-----------DELIVERY TYPE-----------");
        System.out.println("1- ON FOOT");
        System.out.println("2- BICYCLE");
        System.out.println("3- MOTORCYCLE");
        System.out.println("choose an option:");

        option = sc.nextLine();
        switch (option) {
            case "1":
                return DeliveryType.ON_FOOT;
            case "2":
                return DeliveryType.BICYCLE;
            case "3":
                return DeliveryType.MOTORCYCLE;
            default:
                throw new InvalidMenuOptionException();
        }
    }
    //---------------------DELIVERY--------------------
    public static void deliverOrder() throws NumberFormatException, OrderIdNotFoundException, NullPointerException {
        int id;
        Order o;

        System.out.println("----------DELIVERY---------");
        System.out.println("choose order ID:");

        id = Integer.parseInt(sc.nextLine());

        o = orders.stream()
                .filter(order -> order.getID() == id)
                .findFirst()
                .orElse(null);

        if(o==null){
            throw new OrderIdNotFoundException();
        }
        o.getDelivery().setAvailable(true);
        orders.remove(o);
        deliveredOrders.add(o);
        System.out.println("Order successfully delivered");
    }
//--------------orders list-------------------
    public static void listOrders(){
        System.out.println("---------undelivered orders------------");
        orders.forEach(order -> System.out.println(order));
    }
    //--------------Delivered orders list--------------------
    public static void listDeliveredOrders(){
        System.out.println("------------delivered orders--------------");
        deliveredOrders.forEach(order -> System.out.println(order));
    }
}
