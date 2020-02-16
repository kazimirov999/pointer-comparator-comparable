import java.util.Scanner;

public enum CommodityMenu {

    SHOW, ADD, DELETE, CHANGE, SORT, EXIT;

    static Scanner scanner = new Scanner(System.in);

    static CommodityMenu getMenu(){
        boolean c = true;
        if (c){
            System.out.println("Меню: (SHOW, ADD, DELETE, CHANGE, SORT, EXIT): ");
            return CommodityMenu.valueOf(scanner.next().toUpperCase());
        }
        else{
            System.out.println("Ви ввели неправильну команду:");
            return getMenu();
        }
    }
}