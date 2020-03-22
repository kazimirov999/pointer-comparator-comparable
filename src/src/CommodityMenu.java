import java.util.Scanner;

public enum CommodityMenu {

    SHOW, ADD, DELETE, CHANGE, SORT, EXIT;

    static Scanner scanner = new Scanner(System.in);

    static CommodityMenu getMenu(){
        System.out.println("Меню: (SHOW, ADD, DELETE, CHANGE, SORT, EXIT): ");
        return CommodityMenu.valueOf(scanner.next().toUpperCase());
    }
}