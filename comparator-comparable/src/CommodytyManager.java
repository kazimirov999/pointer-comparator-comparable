import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class CommodytyManager {

    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    ArrayList<Commodity> commodities = new ArrayList<>();

    public void addCommodity() throws IOException {
        System.out.print("Enter brand of your commodity - > ");
        String brand = reader.readLine();
        System.out.print("Enter price of your commodity - > ");
        int price = Integer.parseInt(reader.readLine());
        System.out.print("Enter popularity of your commodity - > ");
        int popularity = Integer.parseInt(reader.readLine());
        commodities.add(new Commodity(brand, price, popularity));
    }

    public void removeCommodity() throws IOException {
        ListIterator<Commodity> iterator = commodities.listIterator();
        System.out.print("Enter brand of your commodity to remove - > ");
        String brand = reader.readLine();
        while (iterator.hasNext()){
            Commodity commodity = iterator.next();
            if (commodity.getBrand().toLowerCase().equals(brand.toLowerCase())){
                iterator.remove();
            }
        }
    }

    public void changeCommodity() throws IOException {
        ListIterator<Commodity> iterator = commodities.listIterator();
        System.out.print("Enter brand what you want change - > ");
        String oldBrand = reader.readLine();
        System.out.print("Enter new brand of commodity  - > ");
        String newBrand = reader.readLine();
        System.out.print("Enter price of your commodity - > ");
        int price = Integer.parseInt(reader.readLine());
        System.out.print("Enter popularity of your commodity - > ");
        int popularity = Integer.parseInt(reader.readLine());
        while (iterator.hasNext()){
            Commodity commodity = iterator.next();
            if (commodity.getBrand().toLowerCase().equals(oldBrand.toLowerCase())){
                commodity.setBrand(newBrand);
                commodity.setPrice(price);
                commodity.setPopularity(popularity);
            }

        }
    }

    public void showCommodity(){
        for (Commodity com : commodities){
            System.out.println(com);
        }
    }

}
