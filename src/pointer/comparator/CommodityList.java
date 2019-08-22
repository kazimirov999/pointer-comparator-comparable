package pointer.comparator;

import java.util.*;

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
        Iterator<? extends Commodity> iterator = commodities.iterator();

        while (iterator.hasNext()) {
            Commodity commodity = iterator.next();

            if (this.commodities.contains(commodity)) {
                update(commodity);
                iterator.remove();
            }
        }

        this.commodities.addAll(commodities);
        return true;
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
        this.commodities.removeIf(c -> c.getId() == id);
    }

    public void remove(String name) {
        if (name == null || "".equals(name)) {
            return;
        }

        this.commodities.removeIf(c -> c.getName().equals(name));
    }

    public List<Commodity> sort(Comparator<? super Commodity> comparator) {
        this.commodities.sort(comparator);
        return this.commodities;
    }
}
