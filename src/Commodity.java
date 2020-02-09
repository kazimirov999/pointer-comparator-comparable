import java.util.Objects;

public class Commodity {
    private String name;
    private String model;
    private Integer price;

    public Commodity(String name, String model, int price) {
        this.name = name;
        this.model = model;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Commodity commodity = (Commodity) o;
        return Float.compare(commodity.price, price) == 0 &&
                Objects.equals(name, commodity.name) &&
                Objects.equals(model, commodity.model);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, model, price);
    }

}

