import java.util.Scanner;

public enum CommodityOperations {
    ADD, REMOVE, CHANGE, SORT, EXIT;

    static Scanner scannerCommodityOperations = new Scanner(System.in);

    static CommodityOperations getCommodityOperations() {
        System.out.println("Please enter your command: (ADD, REMOVE, CHANGE, SORT, EXIT)");
        return CommodityOperations.valueOf(scannerCommodityOperations.nextLine().toUpperCase());
    }


}
