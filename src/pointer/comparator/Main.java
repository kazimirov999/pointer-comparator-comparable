package pointer.comparator;

import java.util.Comparator;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static final String DESC = "desc";

    public static void main(String[] args) {
        CommodityList commodityList = new CommodityList();
        Scanner scanner = new Scanner(System.in);

        help();
        Command command = Command.getCommand(scanner);

        while (command != Command.EXIT) {
            try {
                switch (command) {
                    case ADD:
                        boolean isAdded = commodityList.add(new Commodity(scanner.nextInt(), scanner.next(),
                                scanner.nextInt(), scanner.nextLong()));

                        if (isAdded) {
                            System.out.println("Commodity is added.");
                        } else {
                            System.out.println("Commodity is not added. Use new Commodity id.");
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
                        commodityList.update(new Commodity(scanner.nextInt(), scanner.next(), scanner.nextInt(),
                                scanner.nextLong()));
                        break;

                    case SORT:
                        System.out.println(commodityList.sort(getComparator(scanner.next(), scanner.next())));
                        break;

                    case SHOW:
                        System.out.println(commodityList.getCommodities());
                        break;
                }
            } catch (InputMismatchException ex) {
                System.out.println("Wrong command.");
                help();
            }
            command = Command.getNextCommand(scanner);
        }

    }

    private static void help() {
        System.out.println("- add <commodity id:int> <name:String> <price:int> <inStock:long>");
        System.out.println("- remove <commodity id:int> OR remove <name:String>");
        System.out.println("- update <commodity id:int> <name:String> <price:int> <inStock:long>");
        System.out.println("- sort <fieldName:String> <order:String>. Field names: 'id', 'name', 'price', 'inStock'. Order: 'asc', 'desc'.");
    }

    private static Comparator<? super Commodity> getComparator(String fieldName, String order) {
        if (fieldName == null || "".equals(fieldName)) {
            fieldName = "id";
        }

        if (order == null || "".equals(order)) {
            order = "asc";
        }

        if ("name".equalsIgnoreCase(fieldName)) {
            return DESC.equals(order) ? (o1, o2) -> o2.getName().compareTo(o1.getName()) :
                    Comparator.comparing(Commodity::getName);
        }

        if ("price".equalsIgnoreCase(fieldName)) {
            return DESC.equals(order) ? (o1, o2) -> Integer.compare(o2.getPrice(), o1.getPrice()) :
                    Comparator.comparing(Commodity::getPrice);
        }

        if ("inStock".equalsIgnoreCase(fieldName)) {
            return DESC.equals(order) ? (o1, o2) -> Long.compare(o2.getInStock(), o1.getInStock()) :
                    Comparator.comparing(Commodity::getInStock);
        }

        if ("id".equalsIgnoreCase(fieldName) && DESC.equals(order)) {
            return (o1, o2) -> Integer.compare(o2.getId(), o1.getId());
        }

        return Comparator.comparingInt(Commodity::getId);
    }
}