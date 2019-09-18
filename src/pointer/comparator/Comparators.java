package pointer.comparator;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Comparators {
    public static final String ASC = "asc";
    public static final String DESC = "desc";

    private static Map<String, Map<String, Comparator<? super Commodity>>> comparatorMap;

    static {
        comparatorMap = new HashMap<>();

        comparatorMap.put("id",
                getMap(Comparator.comparing(Commodity::getId),
                        (o1, o2) -> Long.compare(o2.getId(), o1.getId())));

        comparatorMap.put("name",
                getMap(Comparator.comparing(Commodity::getName),
                        (o1, o2) -> o2.getName().compareTo(o1.getName())));

        comparatorMap.put("price",
                getMap(Comparator.comparing(Commodity::getPrice),
                        (o1, o2) -> Integer.compare(o2.getPrice(), o1.getPrice())));

        comparatorMap.put("inStock",
                getMap(Comparator.comparing(Commodity::getInStock),
                        (o1, o2) -> Long.compare(o2.getInStock(), o1.getInStock())));
    }

    private static Map<String, Comparator<? super Commodity>> getMap(Comparator<Commodity> ascComparator,
                                                                     Comparator<Commodity> descComparator) {
        Map<String, Comparator<? super Commodity>> map = new HashMap<>();
        map.put(ASC, ascComparator);
        map.put(DESC, descComparator);
        return map;
    }

    public static Comparator<? super Commodity> getComparator(Scanner scanner) {
        return getComparator(scanner.next(), scanner.next());
    }

    public static Comparator<? super Commodity> getComparator(String fieldName, String order) {
        if (!comparatorMap.containsKey(fieldName)) {
            return comparatorMap.get("id").get(ASC);
        }

        Map<String, Comparator<? super Commodity>> map = comparatorMap.get(fieldName);

        return map.containsKey(order) ? map.get(order) : map.get(ASC);
    }
}