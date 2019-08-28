public class Commodity {
    private String name;
    private float price;
    private int quantity = 1;

    public String getName() {
        return name;
    }

    public float getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public Commodity(String name, float price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public Commodity(String name, float price) {
        this.name = name;
        this.price = price;
    }
}
