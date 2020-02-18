import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<Commodity> commodities = new ArrayList<>();
        
        commodities.add(new Commodity("Хліб", 14, 1.0));
        commodities.add(new Commodity("Яйця", 20, 3.2));
        commodities.add(new Commodity("Дрова", 30, 4.7));
        commodities.add(new Commodity("Апельсини", 17, 5.9));
        commodities.add(new Commodity("Банани", 56, 17.5));
        commodities.add(new Commodity("Мука", 325, 140.0));
        commodities.add(new Commodity("Гречка", 24, 6.1));
        commodities.add(new Commodity("Цукор", 654, 97.4));
        commodities.add(new Commodity("Рис", 220, 33.0));
        commodities.add(new Commodity("Булочки", 14, 2.4));

        CommodityCentre commodityCentre = new CommodityCentre(commodities);

        commodityCentre.showMenu();
        commodityCentre.addProduct();
        commodityCentre.deleteProduct();
        commodityCentre.changeProduct();
        commodityCentre.showList();
        commodityCentre.sortProducts();
    }
}
