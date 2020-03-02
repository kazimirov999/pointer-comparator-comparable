import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;


public class CommodityFinder {
    private List<Commodity> commodityList = new ArrayList<>();
    private Scanner commodityscanner = new Scanner(System.in);

    CommodityFinder(List<Commodity> commodityList) {
        this.commodityList = commodityList;
    }

    void showPossibility() {
        boolean c = true;
        while (c) {

            switch (CommodityPossibility.getPossibility()) {
                case ADD:
                    add();
                    break;
                case SHOW:
                    showList();
                    break;
                case SORT:
                    sortProducts();
                    break;
                case CHANGE:
                    changeProduct();
                    break;
                case REMOVE:
                    removeProduct();
                    break;
                case EXIT:
                    System.out.println("You are exit.");
                    c = false;
                    System.exit(0);

            }
        }
    }

    void showList() {
        for (Commodity commodity : commodityList) {
            System.out.println("Commodity List " + commodity);
        }
    }

    void add() {
        System.out.println("Add product`s name ");
        String pro = commodityscanner.next();
        System.out.println("Add product`s price ");
        int p = commodityscanner.nextInt();
        System.out.println("Add product`s rating  ");
        int r = commodityscanner.nextInt();
        commodityList.add(new Commodity(pro, p, r));

    }

    void sortProducts() {
        System.out.println("Write criteria would you find product(name Product, Price, Raring): ");
        String str = commodityscanner.next();
        if (str.equals("nameProduct")) {
            System.out.println("Sorted by name");
            commodityList.sort(((o1, o2) -> o1.getProductName().compareTo(o2.getProductName())));
        } else if (str.equals("Price")) {
            System.out.println("Sorted by price");
            commodityList.sort(((o1, o2) -> o1.getPrice() - o2.getPrice()));
        } else if (str.equals("Rating "))
            System.out.println("Sorted by rating");
        commodityList.sort(((o1, o2) -> o1.getRating() - o2.getRating()));
    }

    void changeProduct() {
        System.out.println("Write product name to change ");
        String pro = commodityscanner.next();
        ListIterator<Commodity> iterator = commodityList.listIterator();
        while (iterator.hasNext()) {
            if (pro.equals(iterator.next().getProductName())) {
                System.out.println("Write new product name ");
                String pronew = commodityscanner.next();
                System.out.println("Write new product price ");
                int p = commodityscanner.nextInt();
                System.out.println("Введіть вагу товару: ");
                int r = commodityscanner.nextInt();
                iterator.set(new Commodity(pronew, p, r));
            }
        }
    }

    void removeProduct() {
        System.out.println("Введіть ім`я товару: ");
        String pro = commodityscanner.next();
        commodityList.removeIf(commodity -> pro.equals(commodity.getProductName()));
    }
}

