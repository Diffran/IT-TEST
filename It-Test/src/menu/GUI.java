package menu;

public class GUI {
    public static void mainMenu(){
        System.out.println("------------MAIN MENU----------------");
        System.out.println("1- new order");
        System.out.println("2- deliver order");
        System.out.println("3- list not delivered orders");
        System.out.println("4- list delivered orders");
        System.out.println("5- exit");
        System.out.println("Choose an option: ");
    }
    public static void clientMenu(){
        System.out.println("----------CLIENT MENU---------");
        System.out.println("Choose a clients name: ");
    }
    public static void itemListMenu(){
        System.out.println("-----------ITEM LIST----------------");
        System.out.println("1- Choose an item");
        System.out.println("2- Complete Order");
    }
}
