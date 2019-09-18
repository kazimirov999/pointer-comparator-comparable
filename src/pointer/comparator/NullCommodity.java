package pointer.comparator;

public class NullCommodity extends Commodity {

    public NullCommodity() {
        super(0, "no commodity", 0, 0);
    }

    public boolean isNull() {
        return true;
    }

    @Override
    public String toString() {
        return "no commodity";
    }
}
