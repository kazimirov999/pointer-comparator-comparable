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
        boolean d = true;
        while (d) {

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
                    d = false;
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

    void sortProducts(){
        System.out.println("Введіть тип за яким Ви бажаєте посортувати продукти(nameProduct, price, weight): ");
        String type = scanner.next();
        if (type.equals("nameProduct")){
            System.out.println("Посортований список за ім`ям.");
            commodityList.sort(((o1, o2) -> o1.getNameProduct().compareTo(o2.getNameProduct())));
            }
        else if (type.equals("price")){
            System.out.println("Посортований список за ціною.");
            commodityList.sort(((o1, o2) -> o1.getPrice()-o2.getPrice()));
        }
        else if (type.equals("weight"))
        System.out.println("Посортований список за вагою.");
        commodityList.sort(((o1, o2) -> Double.compare(o1.getWeight(), o2.getWeight())));
    }
}