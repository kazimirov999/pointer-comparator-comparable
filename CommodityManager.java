package com.pointer.comparable;

import java.util.*;

public class CommodityManager {
    private List<Commodity> commodityList;
    private int idCounter;
    private static final String DEFAULT_SORTING_ORDER = "decrease";
    Scanner in = new Scanner(System.in);

    public CommodityManager(List<Commodity> commodityList) {
        this.idCounter = 0;
        this.commodityList = commodityList;
    }


    void startMenu() {
        boolean flg = true;
        while (flg) {

            switch (Commands.getCommand()) {
                case ADD:
                    add();
                    break;
                case DELETE:
                    delete();
                    break;
                case UPDATE:
                    update();
                    break;
                case SORT:
                    sort();
                    break;
                case SHOW:
                    show();
                    break;
                case EXIT:
                    System.out.println("Exiting...");
                    flg = false;
                    break;
            }
        }

    }


    void add() {
        System.out.println("Enter name, price and number of new commodity");
        Commodity newCommodity = new Commodity(idCounter, in.next(), in.nextDouble(), in.nextInt());
        if (commodityList.contains(newCommodity)) {
            System.out.println("Already added");
        } else {
            commodityList.add(newCommodity);
            idCounter++;
        }

        System.out.println("Added");
    }


    void delete() {
        System.out.println("Enter name: ");
        String name = in.next();
        Iterator<Commodity> iterator = commodityList.listIterator();
        while (iterator.hasNext()) {
            if (name.equals(iterator.next().getName())) {
                iterator.remove();
            }
        }
    }

    void update() {
        System.out.println("Enter ID: ");
        int id = in.nextInt();
        Iterator<Commodity> iterator = commodityList.listIterator();
        while (iterator.hasNext()) {
            if (id == iterator.next().getId()) {
                ((ListIterator<Commodity>) iterator).set(new Commodity(id, Commands.in.nextLine(), Commands.in.nextDouble(), Commands.in.nextInt()));
            }
        }
    }

    void sort() {
        System.out.println("Enter sorting order: decrease or increase");
        System.out.println("Warning!!! If you enter anything but these commands the program will sort in increasing order.");
        String order = in.next().toLowerCase();
        System.out.println("Enter field: name, id, price, stock");
        String field = in.next().toLowerCase();

        if (field.equals("name")) {
            Collections.sort(commodityList, new NameComparator(order));
            System.out.println("Sorted");
        }
        if (field.equals("id")) {
            Collections.sort(commodityList, new IdComparator(order));
            System.out.println("Sorted");
        }
        if (field.equals("price")) {
            Collections.sort(commodityList, new PriceComparator(order));
            System.out.println("Sorted");
        }
        if (field.equals("stock")) {
            Collections.sort(commodityList, new InStockComparator(order));
            System.out.println("Sorted");
        }
    }


    void show() {
        Iterator<Commodity> iterator = commodityList.listIterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    private class NameComparator implements Comparator<Commodity> {
        private String order;

        public NameComparator(String order) {
            this.order = order;
        }

        @Override
        public int compare(Commodity o1, Commodity o2) {
            if (order.equals(DEFAULT_SORTING_ORDER)) {
                return o1.getName().compareTo(o2.getName());
            } else {
                return o2.getName().compareTo(o1.getName());
            }
        }
    }


    private class IdComparator implements Comparator<Commodity> {
        private String order;

        public IdComparator(String order) {
            this.order = order;
        }

        @Override
        public int compare(Commodity o1, Commodity o2) {
            if (order.equals(DEFAULT_SORTING_ORDER)) {
                return Integer.compare(o1.getId(), o2.getId());
            } else {
                return Integer.compare(o2.getId(), o1.getId());
            }
        }
    }

    private class PriceComparator implements Comparator<Commodity> {
        private String order;

        public PriceComparator(String order) {
            this.order = order;
        }

        @Override
        public int compare(Commodity o1, Commodity o2) {
            if (order.equals(DEFAULT_SORTING_ORDER)) {
                return Double.compare(o1.getPrice(), o2.getPrice());
            } else {
                return Double.compare(o2.getPrice(), o1.getPrice());
            }
        }
    }

    private class InStockComparator implements Comparator<Commodity> {
        private String order;

        public InStockComparator(String order) {
            this.order = order;
        }

        @Override
        public int compare(Commodity o1, Commodity o2) {
            if (order.equals(DEFAULT_SORTING_ORDER)) {
                return Integer.compare(o1.getInStock(), o2.getInStock());
            } else {
                return Integer.compare(o2.getInStock(), o1.getInStock());
            }
        }
    }


}

