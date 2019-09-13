import java.util.*;

public class CommodityManager {
    private static Scanner scan = new Scanner(System.in);

    private static void delete(List<Commodity> list, String name, float price, int quantity) {
        list.removeIf(commodity -> {
            boolean namesAreEquals = commodity.getName().equalsIgnoreCase(name);
            boolean pricesAreEquals = commodity.getPrice() == price;
            boolean quantitiesAreEquals = commodity.getQuantity() == quantity;
            return namesAreEquals && pricesAreEquals && quantitiesAreEquals;
        });
    }

    private static void delete(List<Commodity> list, String name, float price) {
        list.removeIf(commodity -> commodity.getName().equalsIgnoreCase(name) && commodity.getPrice() == price);
    }

    private static void delete(List<Commodity> list, String name) {
        list.removeIf(commodity -> commodity.getName().equalsIgnoreCase(name));
    }

    private static void replaceWithQuantity(List<Commodity> list, String name, float price) {
        for (Commodity currentCommodity: list){
            boolean namesAreEquals = currentCommodity.getName().equalsIgnoreCase(name);
            boolean pricesAreEquals = currentCommodity.getPrice() == price;
            if (namesAreEquals && pricesAreEquals) {
                System.out.println("Write wannabe commodity name:");
                String inputName = scan.next();
                System.out.println("Write wannabe commodity price:");
                float inputPrice = scan.nextFloat();
                System.out.println("Write wannabe commodity quantity:");
                int inputQuantity = scan.nextInt();
                System.out.println("Replacing " + currentCommodity.getName() + " with " + currentCommodity.getPrice() +
                        " price and " + currentCommodity.getQuantity() + "quantity to: " + inputName + " " + inputPrice +
                        " " + inputQuantity);
                list.set(list.indexOf(currentCommodity), new Commodity(inputName, inputPrice, inputQuantity));
            }
        }
    }

    private static void replace(List<Commodity> list, String name, float price) {
        for (Commodity currentCommodity: list){
            boolean namesAreEquals = currentCommodity.getName().equalsIgnoreCase(name);
            boolean pricesAreEquals = currentCommodity.getPrice() == price;
            if (namesAreEquals && pricesAreEquals) {
                System.out.println("Write wannabe commodity name:");
                String inputName = scan.next();
                System.out.println("Write wannabe commodity price:");
                float inputPrice = scan.nextFloat();
                System.out.println("Replacing " + currentCommodity.getName() + " with " + currentCommodity.getPrice() +
                        " price to: " + inputName + " " + inputPrice);
                list.set(list.indexOf(currentCommodity), new Commodity(inputName, inputPrice));
            }
        }
    }

    public static void print(List<Commodity> list) {
        for (Commodity c : list) {
            System.out.println("Name: " + c.getName() + "; Price: " + c.getPrice() + "; Quantity: " + c.getQuantity() + ".");
        }
    }

    public static void add(List<Commodity> list) {
        System.out.println("Write name of commodity you want to add:");
        String inputName = scan.next();
        System.out.println("Write price of commodity you want to add:");
        float inputPrice = scan.nextFloat();
        System.out.println("Write quantity of commodity you want to add:");
        int inputQuantity = scan.nextInt();
        list.add(new Commodity(inputName, inputPrice, inputQuantity));
    }

    public static void doDelete(List<Commodity> list) {
        System.out.println("Do you want to choose price?(Yes/No)");
        String priceAnswer = scan.next();
        if (priceAnswer.equalsIgnoreCase("Yes")) {
            System.out.println("Do you want to choose quantity?(Yes/No)");
            String quantityAnswer = scan.next();
            if (quantityAnswer.equalsIgnoreCase("Yes")) {
                System.out.println("Write name of commodity you want to replace:");
                String inputName = scan.next();
                System.out.println("Write price of commodity you want to replace:");
                float inputPrice = scan.nextFloat();
                System.out.println("Write quantity of commodity you want to replace:");
                int inputQuantity = scan.nextInt();
                delete(list, inputName, inputPrice, inputQuantity);
            } else if (quantityAnswer.equalsIgnoreCase("No")) {
                System.out.println("Write name of commodity you want to replace:");
                String inputName = scan.next();
                System.out.println("Write price of commodity you want to replace:");
                float inputPrice = scan.nextFloat();
                delete(list, inputName, inputPrice);
            }
        } else if (priceAnswer.equalsIgnoreCase("No")) {
            System.out.println("Write name of commodity you want to replace:");
            String inputName = scan.next();
            delete(list, inputName);
        }

    }

    public static void doReplace(List<Commodity> list) {
        System.out.println("Write name of commodity you want to replace:");
        String inputName = scan.next();
        System.out.println("Write price of commodity you want to replace:");
        float inputPrice = scan.nextFloat();
        System.out.println("Do you want to set quantity?(Yes/No)");
        String answer = scan.next();
        if (answer.equalsIgnoreCase("Yes")) {
            replaceWithQuantity(list, inputName, inputPrice);
        } else if (answer.equalsIgnoreCase("No")) {
            replace(list, inputName, inputPrice);
        }
    }

    public static void doSort(List<Commodity> list) {
        System.out.println("Choose sorting method" +
                "\n1 - Sort by name" +
                "\n2 - Sort by price" +
                "\n3 - Sort by quantity");
        int sortMethod = scan.nextInt();
        System.out.println("Choose sorting direction" +
                "\n1 - Direct" +
                "\n2 - Reversed");
        int sortDirection = scan.nextInt();
        switch (sortMethod) {
            case 1:
                if (sortDirection == 1) {
                    list.sort(Comparator.comparing(Commodity::getName));
                    break;
                } else if (sortDirection == 2) {
                    list.sort((commodity1, commodity2) -> commodity2.getName().compareTo(commodity1.getName()));
                    break;
                }
            case 2:
                if (sortDirection == 1) {
                    list.sort((commodity1, commodity2) -> (int) (commodity1.getPrice() - commodity2.getPrice()));
                    break;
                } else if (sortDirection == 2) {
                    list.sort((commodity1, commodity2) -> (int) (commodity2.getPrice() - commodity1.getPrice()));
                    break;
                }
            case 3:
                if (sortDirection == 1) {
                    list.sort(Comparator.comparingInt(Commodity::getQuantity));
                    break;
                } else if (sortDirection == 2) {
                    list.sort((commodity1, commodity2) -> commodity2.getQuantity() - commodity1.getQuantity());
                    break;
                }
        }
    }

    public static void start(List<Commodity> list) {
        boolean isOn = true;
        while (isOn) {
            System.out.println("Choose function" +
                    "\n1 - Add commodity to list" +
                    "\n2 - Delete commodity from list" +
                    "\n3 - Replace commodity with commodity you want" +
                    "\n4 - Sort list of commodities" +
                    "\n5 - Print all commodities with prices and quantities" +
                    "\n0 - Exit");
            System.out.println("------------------------------------");
            int function = scan.nextInt();
            switch (function) {
                case 1:
                    add(list);
                    System.out.println("------------------------------------");
                    break;
                case 2:
                    doDelete(list);
                    System.out.println("------------------------------------");
                    break;
                case 3:
                    doReplace(list);
                    System.out.println("------------------------------------");
                    break;
                case 4:
                    doSort(list);
                    break;
                case 5:
                    print(list);
                    System.out.println("------------------------------------");
                    break;
                case 0:
                    isOn = false;
                    break;
                default:
                    System.out.println("Wrong function, choose again");
                    break;
            }
        }
    }
}
