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
                GUI.mainMenu();
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
            }catch(InvalidMenuOptionException e){
                System.out.println(e.getMessage());
            }catch(NoClientException e){
                System.out.println(e.getMessage());
            }catch(NoFreeDeliveryDriverException e){
                System.out.println(e.getMessage());
            }catch(NumberFormatException e){
                System.out.println("ERROR: "+ e.getMessage());
            }catch(EmptyItemsListException e){
                System.out.println(e.getMessage());
            }catch(NoIDException e){
                System.out.println(e.getMessage());
            }catch (NullPointerException e){
                System.out.println(e.getMessage());
            }
        }while(!option.equals("5"));

    }
}
