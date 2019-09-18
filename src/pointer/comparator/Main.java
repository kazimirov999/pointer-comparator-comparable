package pointer.comparator;

import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;
import java.util.function.BiConsumer;

public class Main {
    private static Map<Command, BiConsumer<CommodityList, Scanner>> commandMap = new HashMap<>();

    static {
        commandMap.put(Command.ADD, (list, scanner) -> System.out.println(list.add(createCommodity(scanner)) ?
                "Commodity is added." :
                "Commodity is not added. Use new positive Commodity id."));

        commandMap.put(Command.UPDATE, (list, scanner) -> System.out.println(list.update(createCommodity(scanner)) ?
                "Commodity is updated." :
                "Commodity is not added. Wrong commodity ID."));

        commandMap.put(Command.REMOVE, (list, scanner) -> {
            if (scanner.hasNextInt()) {
                list.remove(scanner.nextInt());
            } else {
                list.remove(scanner.next());
            }
        });

        commandMap.put(Command.SHOW, (list, scanner) -> {

            if (scanner.hasNextInt()) {
                System.out.println(list.search(scanner.nextInt()));
                return;
            }

            if (scanner.hasNext()) {
                String next = scanner.next();
                System.out.println("all".equalsIgnoreCase(next) ? list.getCommodities() : list.search(next));
            }
        });

        commandMap.put(Command.SORT, (list, scanner) -> System.out.println(list.sort(Comparators.getComparator(scanner))));
        commandMap.put(Command.HELP, (list, scanner) -> help());
    }

    public static void main(String[] args) {
        CommodityList commodityList = new CommodityList();
        Scanner scanner = new Scanner(System.in);

        help();
        Command command = Command.getCommand(scanner);

        while (command != Command.EXIT) {
            try {
                commandMap.get(command).accept(commodityList, scanner);
            } catch (InputMismatchException ex) {
                System.out.println("Wrong command.");
                help();
            } finally {
                scanner.nextLine();
                command = Command.getCommand(scanner);
            }
        }
    }

    private static void help() {
        System.out.println("- show all | <commodity id:int> | <name:String>\n" +
                "- add <commodity id:int> <name:String> <price:int> <inStock:long>\n" +
                "- remove <commodity id:int> OR remove <name:String>\n" +
                "- update <commodity id:int> <name:String> <price:int> <inStock:long>\n" +
                "- sort <fieldName:String> <order:String>. Field names: ['id', 'name', 'price', 'inStock']. Order: ['asc', 'desc'].");
    }

    private static Commodity createCommodity(Scanner scanner) {
        return new Commodity(scanner.nextInt(), scanner.next(), scanner.nextInt(), scanner.nextLong());
    }
}