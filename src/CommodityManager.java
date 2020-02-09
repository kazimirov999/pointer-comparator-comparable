import java.util.*;

public class CommodityManager {
    private List<Commodity> commodityList = new ArrayList<>();
    private Scanner commodityScanner = new Scanner(System.in);

    public void startProgram() {
        boolean run = true;
        while (run) {
            switch (CommodityOperations.getCommodityOperations()) {
                case ADD:
                    add();
                    break;
                case REMOVE:
                    remove();
                    break;
                case CHANGE:
                    change();
                case SORT:
                    sort();
                case EXIT:
                    run = false;
                    break;
            }
        }
    }

    public void add() {
        System.out.println("Add commodity name, commodity model, commodity price:");
        commodityList.add(new Commodity(commodityScanner.nextLine(), commodityScanner.nextLine(),
                commodityScanner.nextInt()));
    }

    public void remove() {
        Iterator<Commodity> commodityIterator = commodityList.iterator();
        System.out.println("Input commodity name to remove:");
        String inputCommodityName = commodityScanner.nextLine();
        while (commodityIterator.hasNext()) {
            Commodity commodity = commodityIterator.next();
            if (commodity.getName().equals(inputCommodityName)) {
                commodityIterator.remove();
                System.out.println("You remove: " + commodity.getName());
            } else {
                System.out.println("Error (1) ''Commodity name not find !''");
            }
        }

    }

    public void change() {
        Iterator<Commodity> commodityIterator = commodityList.iterator();
        System.out.println("Input commodity name to change other parameters:");
        String inputCommodityName = commodityScanner.nextLine();
        System.out.println("Input new information to commodity model:");
        String inputCommodityModel = commodityScanner.nextLine();
        System.out.println("Input new information to commodity price:");
        float inputCommodityPrice = commodityScanner.nextFloat();
        while (commodityIterator.hasNext()) {
            Commodity commodity = commodityIterator.next();
            if (commodity.getName().equals(inputCommodityName)) {
                commodity.setModel(inputCommodityModel);
                commodity.setPrice((int) inputCommodityPrice);
            } else {
                System.out.println("Error (1) ''Commodity name not find !''");
            }
        }

    }

    public void sort() {
        boolean run = true;
        while (run) {
            switch (CommodityOperationsSearch.getCommodityOperationsSearch()) {
                case NAME:
                    searchByName();
                    break;
                case MODEL:
                    searchByModel();
                    break;
                case PRICE:
                    searchByPrice();
                case EXIT:
                    run = false;
                    break;
            }

        }
    }

    public void searchByName() {
        System.out.println("Press (1) if you wont sort at FIRST to LAST");
        System.out.println("Press (2) if you wont sort at LAST to FIRST");
        int inputChoice = commodityScanner.nextInt();
        if (inputChoice == 1) {
            commodityList.sort(Comparator.comparing(Commodity::getName));
        } else if (inputChoice == 2) {
            commodityList.sort((commodityList1, commodityList2) ->
                    commodityList2.getName().compareTo(commodityList1.getName()));
        } else {
            System.out.println("Error (2) ''You press another key''");
        }

    }

    public void searchByModel() {
        System.out.println("Press (1) if you wont sort at FIRST to LAST");
        System.out.println("Press (2) if you wont sort at LAST to FIRST");
        int inputChoice = commodityScanner.nextInt();
        if (inputChoice == 1) {
            commodityList.sort(Comparator.comparing(Commodity::getModel));
        } else if (inputChoice == 2) {
            commodityList.sort((commodityList1, commodityList2) ->
                    commodityList2.getModel().compareTo(commodityList1.getModel()));
        } else {
            System.out.println("Error (2) ''You press another key''");
        }
    }

    private void searchByPrice() {
        System.out.println("Press (1) if you wont sort at MORE EXPENSIVE to CHEAPER");
        System.out.println("Press (2) if you wont sort at CHEAPER to MORE EXPENSIVE");
        int inputChoice = commodityScanner.nextInt();
        if (inputChoice == 1) {
            commodityList.sort(Comparator.comparing(Commodity::getPrice));
        } else if (inputChoice == 2) {
            commodityList.sort((commodityList1, commodityList2) ->
                    commodityList2.getPrice().compareTo(commodityList1.getPrice()));
        } else {
            System.out.println("Error (2) ''You press another key''");
        }
    }
}