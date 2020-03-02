import java.util.Objects;

public class Commodity {
    private String productName;
    private Integer price;
    private Integer rating;

    public Commodity(String productName, int price, int rating) {
        this.productName = productName;
        this.price = price;
        this.rating = rating;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Commodity commodity = (Commodity) o;
        return Double.compare(commodity.price, price) == 0 &&
                Double.compare(commodity.rating, rating) == 0 &&
                Objects.equals(productName, commodity.productName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productName, price, rating);
    }
}
