import java.util.Scanner;

public enum CommodityPossibility {
    SHOW, ADD, SORT, CHANGE, REMOVE, EXIT;
    static Scanner commodityPossibility = new Scanner(System.in);

    static public CommodityPossibility getPossibility() {
        boolean k = true;
        if (k) {
            System.out.println(" Hello, write your`s command: ( SHOW, ADD, SORT, CHANGE, REMOVE, EXIT)");
            return CommodityPossibility.valueOf(commodityPossibility.nextLine().toUpperCase());
        } else {
            System.out.println(" Wrong command:");
            return getPossibility();
        }
    }
}


