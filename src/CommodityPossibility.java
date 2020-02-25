import java.util.Scanner;

public enum CommodityPossibility {
    ADD, SORT, CHANGE, REMOVE, EXIT;
    static Scanner commodityPossibility = new Scanner(System.in);

    static public CommodityPossibility getPossibility() {
        System.out.println(" Hello, write your`s command: ( ADD, SORT, CHANGE, REMOVE, EXIT)");
        return CommodityPossibility.valueOf(commodityPossibility.nextLine().toUpperCase());
    }
}

