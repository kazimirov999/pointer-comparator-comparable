import java.util.Comparator;

public class SortedByPrice implements Comparator<Commodity> {
    @Override
    public int compare(Commodity o1, Commodity o2) {
        return o1.getPrice() - o2.getPrice();
    }
}
