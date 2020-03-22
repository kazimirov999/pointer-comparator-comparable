import java.util.Comparator;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;

public class CommodityCentre {

    private List<Commodity> commodityList;
    Scanner scanner = new Scanner(System.in);

    CommodityCentre(List<Commodity> commodityList) {
        this.commodityList = commodityList;
    }

    void showMenu() {
        while (true) {
            switch (CommodityMenu.getMenu()) {
                case ADD:
                    addProduct();
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
                case DELETE:
                    deleteProduct();
                    break;
                case EXIT:
                    System.out.println("Ви вийшли з програми!");
                    System.exit(0);
            }
        }
    }

    void showList(){
        for (Commodity commodity : commodityList){
            System.out.println("Список продуктів: " + commodity);
        }
    }

    void addProduct() {
        System.out.println("Введіть ім`я товару: ");
        String n = scanner.next();
        System.out.println("Введіть ціну товару: ");
        int p = scanner.nextInt();
        System.out.println("Введіть вагу товару: ");
        double w = scanner.nextDouble();
        commodityList.add(new Commodity(n, p, w));
    }

    void deleteProduct() {
        System.out.println("Введіть ім`я товару: ");
        String n = scanner.next();
        commodityList.removeIf(commodity -> n.equals(commodity.getNameProduct()));
    }

    void changeProduct() {
        System.out.println("Введіть ім`я товару, що бажаєте замінити: ");
        String n = scanner.next();
        ListIterator<Commodity> iterator = commodityList.listIterator();
        while (iterator.hasNext()) {
            if (n.equals(iterator.next().getNameProduct())) {
                System.out.println("Введіть нове ім`я товару: ");
                String name = scanner.next();
                System.out.println("Введіть ціну товару: ");
                int c = scanner.nextInt();
                System.out.println("Введіть вагу товару: ");
                double w = scanner.nextDouble();
                iterator.set(new Commodity(name, c, w));
            }
        }
    }

    void sortProducts() {
        System.out.println("Введіть тип за яким Ви бажаєте посортувати продукти(nameProduct, price, weight): ");
        String type = scanner.next();
        switch (type) {
            case "nameProduct":
                System.out.println("Посортований список за ім`ям.");
                commodityList.sort((Comparator.comparing(Commodity::getNameProduct)));
                System.out.println(commodityList);
                break;
            case "price":
                System.out.println("Посортований список за ціною.");
                commodityList.sort((Comparator.comparingInt(Commodity::getPrice)));
                System.out.println(commodityList);
                break;
            case "weight":
                System.out.println("Посортований список за вагою.");
                commodityList.sort((Comparator.comparingDouble(Commodity::getWeight)));
                System.out.println(commodityList);
                break;
        }
    }
}