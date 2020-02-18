import java.util.Comparator;

public class Commodity {

    private String brand;
    private int price;
    private int popularity;

    public Commodity(String brand, int price, int popularity) {
        this.brand = brand;
        this.price = price;
        this.popularity = popularity;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getPopularity() {
        return popularity;
    }

    public void setPopularity(int popularity) {
        this.popularity = popularity;
    }

    @Override
    public String toString() {
        String propuskBrand = "";
        String propuskPrice = "";
        int bl = 8 - brand.length();
        int pl = 8 - Integer.toString(price).length();
        String strbl [] = new String[bl];
        String strpl [] = new String[pl];
        for (int i = 0; i < bl; i ++){
            strbl[i] = " ";
            propuskBrand += strbl[i];
        }
        for (int i = 0; i < pl; i ++){
            strpl[i] = " ";
            propuskPrice += strpl[i];
        }
        return brand + propuskBrand + " | " + price + propuskPrice + " | " + popularity + " |";
    }
}
