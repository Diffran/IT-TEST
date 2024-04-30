package menu;

import exceptions.InvalidMenuOptionException;
import exceptions.NoClientException;
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
                        break;
                    case "3":
                        break;
                    case "4":
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
            }
        }while(!option.equals("5"));

    }
}
