package pointer.comparator;

import java.util.Objects;

public class Commodity {
    private int id;
    private String name;
    private int price;
    private long inStock;

    public Commodity(int id, String name, int price, long inStock) {
        this.id = id >= 0 ? id : 0;
        setName(name);
        setPrice(price);
        setInStock(inStock);
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public long getInStock() {
        return inStock;
    }

    public void setName(String name) {
        this.name = (name == null || name.isEmpty()) ? "Commodity" : name;
    }

    public void setPrice(int price) {
        this.price = price >= 0 ? price : 0;
    }

    public void setInStock(long inStock) {
        this.inStock = inStock >= 0 ? inStock : 0;
    }

    public boolean hasId(int id) {
        return getId() == id;
    }

    public boolean hasName(String name) {
        return getName().equals(name);
    }

    public boolean hasPrice(int price) {
        return getPrice() == price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Commodity)) return false;
        Commodity commodity = (Commodity) o;
        return getId() == commodity.getId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName());
    }

    @Override
    public String toString() {
        return "Commodity{" +
                "id=" + id +
                ", name='" + name +
                "', price=" + price +
                ", inStock=" + inStock +
                '}';
    }
}