package pointer.comparator;

import java.util.Collection;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class CommodityList {

    private List<Commodity> commodities = new LinkedList<>();

    public CommodityList() {
    }

    public CommodityList(Collection<? extends Commodity> commodities) {
        addAll(commodities);
    }

    public List<Commodity> getCommodities() {
        return commodities;
    }

    public boolean add(Commodity commodity) {
        if (commodity == null || this.commodities.contains(commodity)) {
            return false;
        }

        return this.commodities.add(commodity);
    }

    public boolean addAll(Collection<? extends Commodity> commodities) {
        commodities.removeIf(commodity -> update(commodity));

        return this.commodities.addAll(commodities);
    }

    public Commodity search(int id) {
        for (Commodity commodity : commodities) {
            if (commodity.getId() == id) {
                return commodity;
            }
        }

        return null;
    }

    public List<Commodity> search(String name) {
        List<Commodity> commodityList = new LinkedList<>();

        if (name == null || name.isEmpty()) {
            return commodityList;
        }

        for (Commodity commodity : commodities) {
            if (name.equals(commodity.getName())) {
                commodityList.add(commodity);
            }
        }

        return commodityList;
    }

    public boolean update(Commodity commodity) {
        int index = this.commodities.indexOf(commodity);

        if (commodity == null || index == -1) {
            return false;
        }

        this.commodities.set(index, commodity);
        return true;
    }

    public void remove(int id) {
        this.commodities.removeIf(c -> c.hasId(id));
        System.out.println("Commodity with ID '" + id + "' is removed.");
    }

    public void remove(String name) {
        if (name == null || name.isEmpty()) {
            return;
        }

        this.commodities.removeIf(c -> c.hasName(name));
        System.out.println("Commodity with name '" + name + "' is removed.");
    }

    public void remove(String name, int price) {
        this.commodities.removeIf(c -> c.hasName(name) && c.hasPrice(price));
        System.out.println("Commodities with price '" + price + "' is removed.");
    }

    public void remove(int id, String name, int price) {
        this.commodities.removeIf(c -> c.hasId(id) && c.hasName(name) && c.hasPrice(price));
        System.out.println("Commodities with price '" + price + "' is removed.");
    }

    public List<Commodity> sort(Comparator<? super Commodity> comparator) {
        this.commodities.sort(comparator);
        return this.commodities;
    }
}