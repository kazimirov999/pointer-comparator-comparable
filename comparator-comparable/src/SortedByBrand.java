import java.util.Comparator;

public class SortedByBrand implements Comparator<Commodity> {
    @Override
    public int compare(Commodity o1, Commodity o2) {

        String str1 = o1.getBrand();
        String str2 = o2.getBrand();

        return str1.compareTo(str2);
    }
}
