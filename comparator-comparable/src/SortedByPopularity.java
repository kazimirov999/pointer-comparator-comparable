import java.util.Comparator;

public class SortedByPopularity implements Comparator<Commodity> {

    @Override
    public int compare(Commodity o1, Commodity o2) {
        return o1.getPopularity() - o2.getPopularity();
    }
}
