import java.util.Scanner;

public enum CommodityOperationsSearch {
    NAME, MODEL, PRICE, EXIT;

    static Scanner scannerCommodityOperationsSearch = new Scanner(System.in);

    static CommodityOperationsSearch getCommodityOperationsSearch() {
        System.out.println("Please enter your command to sort: (NAME, MODEL, PRICE, EXIT)");
        return CommodityOperationsSearch.valueOf(scannerCommodityOperationsSearch.nextLine().toUpperCase());
    }


}
