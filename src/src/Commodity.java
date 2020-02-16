import java.util.Objects;

public class Commodity {

    String nameProduct;
    int price;
    double weight;

    public Commodity(String nameProduct, int price, double weight) {
        this.nameProduct = nameProduct;
        this.price = price;
        this.weight = weight;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public int getPrice() {
        return price;
    }

    public double getWeight() {
        return weight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Commodity commodity = (Commodity) o;
        return price == commodity.price &&
                Double.compare(commodity.weight, weight) == 0 &&
                Objects.equals(nameProduct, commodity.nameProduct);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nameProduct, price, weight);
    }
}
