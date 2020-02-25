import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Iterator;
import java.util.Comparator;

public class SearchingOfCommodity {
    private List<Commodity> commodityList = new ArrayList<>();
    private Scanner commodity = new Scanner(System.in);

    public void start() {
        boolean b= true;
        while (b) {
            switch (CommodityPossibility.getPossibility()) {
                case ADD:
                    add();
                    break;
                case CHANGE:
                    change();
                    break;
                case SORT:
                    sort();
                    break;
                case REMOVE:
                    remove();
                    break;
                case EXIT:
                    System.out.println("Good bye");
                    b = false;
                    System.exit(0);
            }
        }
    }

    public void add() {
        System.out.println(" ADD Product Name, Price and Product rating: ");
        commodityList.add(new Commodity(commodity.nextLine(), commodity.nextInt(),
                commodity.nextInt()));
    }

    void change() {
        Iterator<Commodity> commodityIterator = commodityList.iterator();
        System.out.println("Write product name to change another parameters: ");
        String inputProductName = commodity.nextLine();
        System.out.println("Write new price: ");
        int inputCommodityPrice = commodity.nextInt();
        System.out.println("Write rating : ");
        int inputCommodityRating = commodity.nextInt();
        while (commodityIterator.hasNext()) {
            Commodity commodity = commodityIterator.next();
            if (commodity.getProductName().equals(inputProductName)) {
                commodity.setPrice(inputCommodityPrice);
                commodity.setRating(inputCommodityRating);
            } else {
                System.out.println(" Exception - Product name not found: ");
            }
        }
    }

    public void remove() {
        Iterator<Commodity> commodityIterator = commodityList.iterator();
        System.out.println("write product name to remove:");
        String inputProductName = commodity.nextLine();
        while (commodityIterator.hasNext()) {
            Commodity commodity = commodityIterator.next();
            if (commodity.getProductName().equals(inputProductName)) {
                commodityIterator.remove();
                System.out.println(" You are removed: " + commodity.getProductName());
            } else {
                System.out.println(" Exception - Product name not found: ");
            }
        }
    }

    public void sort() {
        boolean b = true;
        while (b) {
            switch (CommodityPossibilitySearching.getSearching()) {
                case PRODUCT_NAME:
                    findByProductName();
                    break;
                case PRICE:
                    findByPrice();
                    break;
                case RATING:
                    findByRating();
                    break;
                case EXIT:
                    b = false;
                    break;

            }
        }
    }

    public void findByProductName() {
        System.out.println(" If you want to sort from first to last -write 666 ");
        System.out.println(" If you want to sort from last to first -write 777 ");
        int inputSense = commodity.nextInt();
        if (inputSense == 666) {
            commodityList.sort(Comparator.comparing(Commodity::getProductName));
        } else if (inputSense == 777) {
            commodityList.sort((commodityList1, commodityList2) -> commodityList2.getProductName().compareTo(commodityList1.getProductName()));
        } else {
            System.out.println(" Exception- illegal sense.");
        }
    }

    public void findByPrice() {
        System.out.println(" If you want to sort from cheaper to expensive -write 666 ");
        System.out.println(" If you want to sort from expensive  to cheaper -write 777 ");
        int inputPrice = commodity.nextInt();
        if (inputPrice == 666) {
            commodityList.sort(Comparator.comparing(Commodity::getPrice));
        } else if (inputPrice == 777) {
            commodityList.sort((commodityList1, commodityList2) -> commodityList2.getPrice().compareTo(commodityList1.getPrice()));
        } else {
            System.out.println(" Exception- illegal sense.");
        }
    }

    public void findByRating() {
        System.out.println(" If you want to sort from smaller rating to higher -write 666 ");
        System.out.println(" If you want to sort from higher rating  to smaller -write 777 ");
        int inputRating = commodity.nextInt();
        if (inputRating == 666) {
            commodityList.sort(Comparator.comparing(Commodity::getPrice));
        } else if (inputRating == 777) {
            commodityList.sort((commodityList1, commodityList2) -> commodityList2.getRating().compareTo(commodityList1.getRating()));
        } else {
            System.out.println(" Exception- illegal sense.");
        }
    }
}