package order;

import exceptions.InvalidMenuOptionException;
import exceptions.NoClientException;
import item.Item;
import menu.GUI;
import person.Client;
import person.Delivery;

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
    private static List<Order> completedOrders = new ArrayList<>();

    //---------CREATE AN ORDER------------
    public static void newOrder()throws NoClientException, InvalidMenuOptionException {
        Delivery delivery;
        Client client;
        List<Item> items;
        /**
         * client = metodo
         * delivery = metodo
         * items = metodo
         */
        client = pickClient();
        delivery = pickDeliveryDriver();


        Order order = new Order();//omplir els valors
        orders.add(order);
    }

    private static Client pickClient() throws NoClientException{
        String name;

        GUI.clientMenu();
        name = sc.nextLine();

        for(Client client : clients){
            if(client.getName().equals(name)){
                return client;
            }
        }
        throw new NoClientException();
    }
    private static Delivery pickDeliveryDriver(){
        int randomIndex = random.nextInt(deliverers.size());
        boolean free = false;
        do{
            if(deliverers.get(randomIndex).isAvailable()){
                free = true;
                deliverers.get(randomIndex).setAvailable(false);
            }
        }while(false);
        return deliverers.get(randomIndex);
    }
    private static List<Item> pickItemList(){
        GUI.itemListMenu();
    }
}
