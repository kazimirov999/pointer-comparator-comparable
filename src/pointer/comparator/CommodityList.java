package pointer.comparator;

import com.sun.istack.internal.NotNull;

import java.util.*;
import java.util.stream.Collectors;

public class CommodityList {

    private List<Commodity> commodities = new LinkedList<>();
    private NullCommodity nullCommodity = new NullCommodity();

    public CommodityList() {
    }

    public CommodityList(Collection<? extends Commodity> commodities) {
        addAll(commodities);
    }

    public List<Commodity> getCommodities() {
        return commodities;
    }

    public boolean add(@NotNull Commodity commodity) {
        if (commodity.isNull() || commodities.contains(commodity))
            return false;

        return commodities.add(commodity);
    }

    public boolean addAll(Collection<? extends Commodity> commodities) {
        commodities.removeIf(this::update);

        return this.commodities.addAll(commodities);
    }

    public Commodity search(int id) {
        return commodities.stream()
                .filter(c -> c.hasId(id))
                .findFirst()
                .orElse(nullCommodity);
    }

    public List<Commodity> search(String name) {
        return (name == null || name.isEmpty()) ?
                new LinkedList<>() :
                commodities.stream()
                        .filter(c -> name.equals(c.getName()))
                        .collect(Collectors.toList());
    }

    public boolean update(@NotNull Commodity commodity) {
        if (commodity.isNull()) {
            return false;
        }

        ListIterator<Commodity> listIterator = this.commodities.listIterator();

        while (listIterator.hasNext()) {
            if (commodity.equals(listIterator.next())) {
                listIterator.set(commodity);
                return true;
            }
        }

        return false;
    }

    public void remove(int id) {
        this.commodities.removeIf(c -> c.hasId(id));
        System.out.println("Commodity with ID '" + id + "' is removed.");
    }

    public void remove(String name) {
        this.commodities.removeIf(c -> c.hasName(name));
        System.out.println("Commodity with name '" + name + "' is removed.");
    }

    public void remove(String name, int price) {
        this.commodities.removeIf(c -> c.hasName(name) && c.hasPrice(price));
        System.out.println("Commodities with price '" + price + "' is removed.");
    }

    public void remove(@NotNull Commodity commodity) {
        if (commodity.isNull()) {
            System.out.println(commodity + "' is not removed.");
            return;
        }

        this.commodities.removeIf(c -> c.equalsTo(commodity));
        System.out.println(commodity + "' is removed.");
    }

    public List<Commodity> sort(Comparator<? super Commodity> comparator) {
        this.commodities.sort(comparator);
        return this.commodities;
    }
}