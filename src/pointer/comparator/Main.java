package pointer.comparator;

import java.util.*;

public class Main {

    public static final String ASC = "asc";
    public static final String DESC = "desc";
    private static Scanner scanner;

    private static Map<String, Map<String, Comparator<? super Commodity>>> comparatorMap;

    static {
        comparatorMap = new HashMap<>();

        comparatorMap.put("id", new HashMap<>());
        Map<String, Comparator<? super Commodity>> map = comparatorMap.get("id");
        map.put(ASC, Comparator.comparing(Commodity::getId));
        map.put(DESC, (o1, o2) -> Long.compare(o2.getId(), o1.getId()));

        comparatorMap.put("name", new HashMap<>());
        map = comparatorMap.get("name");
        map.put(ASC, Comparator.comparing(Commodity::getName));
        map.put(DESC, (o1, o2) -> Integer.compare(o2.getPrice(), o1.getPrice()));

        comparatorMap.put("price", new HashMap<>());
        map = comparatorMap.get("price");
        map.put(ASC, Comparator.comparing(Commodity::getPrice));
        map.put(DESC, (o1, o2) -> Integer.compare(o2.getPrice(), o1.getPrice()));

        comparatorMap.put("inStock", new HashMap<>());
        map = comparatorMap.get("inStock");
        map.put(ASC, Comparator.comparing(Commodity::getInStock));
        map.put(DESC, (o1, o2) -> Long.compare(o2.getInStock(), o1.getInStock()));
    }

    public static void main(String[] args) {
        CommodityList commodityList = new CommodityList();
        scanner = new Scanner(System.in);

        help();
        Command command = Command.getCommand(scanner.next());

        while (command != Command.EXIT) {
            try {
                switch (command) {
                    case ADD:
                        if (commodityList.add(new Commodity(scanner.nextInt(), scanner.next(),
                                scanner.nextInt(), scanner.nextLong()))) {
                            System.out.println("Commodity is added.");
                        } else {
                            System.out.println("Commodity is not added. Use new positive Commodity id.");
                        }
                        break;

                    case REMOVE:
                        String next = scanner.next();

                        try {
                            commodityList.remove(Integer.parseInt(next));
                        } catch (NumberFormatException e) {
                            commodityList.remove(next);
                        }

                        break;

                    case UPDATE:
                        if (commodityList.update(new Commodity(scanner.nextInt(), scanner.next(), scanner.nextInt(),
                                scanner.nextLong()))) {
                            System.out.println("Commodity is updated.");
                        } else {
                            System.out.println("Commodity is not added. Wrong commodity ID.");
                        }
                        break;

                    case SORT:
                        System.out.println(commodityList.sort(getComparator(scanner.next(), scanner.next())));
                        break;

                    case SHOW:
                        next = scanner.next();

                        if ("all".equals(next)) {
                            System.out.println(commodityList.getCommodities());
                        } else {
                            try {
                                Commodity commodity = commodityList.search(Integer.parseInt(next));
                                System.out.println(commodity == null ? "no commodity" : commodity);
                            } catch (NumberFormatException e) {
                                System.out.println(commodityList.search(next));
                            }
                        }
                        break;
                }
            } catch (InputMismatchException ex) {
                System.out.println("Wrong command.");
                help();
            } finally {
                command = getCommandInNextLine();
            }
        }
    }

    private static void help() {
        StringBuilder helpString = new StringBuilder("- show all | <commodity id:int> | <name:String>\n")
                .append("- add <commodity id:int> <name:String> <price:int> <inStock:long>\n")
                .append("- remove <commodity id:int> OR remove <name:String>\n")
                .append("- update <commodity id:int> <name:String> <price:int> <inStock:long>\n")
                .append("- sort <fieldName:String> <order:String>. Field names: ['id', 'name', 'price', 'inStock']. Order: ['asc', 'desc'].");

        System.out.println(helpString);
    }

    private static Comparator<? super Commodity> getComparator(String fieldName, String order) {

        if (!comparatorMap.containsKey(fieldName)) {
            return comparatorMap.get("id").get(ASC).reversed();
        }

        Map<String, Comparator<? super Commodity>> map = comparatorMap.get(fieldName);

        return map.containsKey(order) ? map.get(order) : map.get(ASC);
    }

    static Command getCommandInNextLine() {
        scanner.nextLine();
        return Command.getCommand(scanner.next());
    }
}