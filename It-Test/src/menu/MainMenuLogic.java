package menu;

import exceptions.*;
import order.OrderLogic;

import java.util.Scanner;

import static java.lang.System.exit;

public class MainMenuLogic {
    private static Scanner sc = new Scanner(System.in);
    private static String option;
    public static void mainMenuLogic(){
        do {
            try {
                System.out.println("------------MAIN MENU----------------");
                System.out.println("1- new order");
                System.out.println("2- deliver order");
                System.out.println("3- list not delivered orders");
                System.out.println("4- list delivered orders");
                System.out.println("5- exit");
                System.out.println("Choose an option: ");

                option = sc.nextLine();

                switch (option) {
                    case "1":
                        OrderLogic.newOrder();
                        break;
                    case "2":
                        OrderLogic.deliverOrder();
                        break;
                    case "3":
                        OrderLogic.listOrders();
                        break;
                    case "4":
                        OrderLogic.listDeliveredOrders();
                        break;
                    case "5":
                        exit(0);
                    default:
                        throw new InvalidMenuOptionException();
                }
            }catch(InvalidMenuOptionException | NoClientException | NoFreeDeliveryDriverException |
                   NumberFormatException | EmptyProductListException | OrderIdNotFoundException
                   | NullPointerException e){
                System.out.println(e.getMessage());
            }
        }while(!option.equals("5"));

    }
}
