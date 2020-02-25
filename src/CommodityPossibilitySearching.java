import java.util.Scanner;

public enum CommodityPossibilitySearching {
    PRODUCT_NAME, PRICE, RATING, EXIT;
    static Scanner commodityPossibilitySearching = new Scanner(System.in);

    static public CommodityPossibilitySearching getSearching() {
        System.out.println("Hello, write your`s criteria to sort:( PRODUCT_NAME, PRICE, RATING, EXIT) ");
        return CommodityPossibilitySearching.valueOf(commodityPossibilitySearching.nextLine().toUpperCase());
    }
}
