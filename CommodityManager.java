package com.pointer.comparable;

import java.util.*;

class CommodityManager {
    private List<Commodity> commodityList;
    private int idCounter;
    private static final String DEFAULT_SORTING_ORDER = "decrease";
    Scanner in = new Scanner(System.in);

    CommodityManager(List<Commodity> commodityList) {
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


   private void add() {
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


   private void delete() {
        System.out.println("Enter name: ");
        String name = in.next();
        commodityList.removeIf(commodity -> name.equals(commodity.getName()));
    }

   private void update() {
        System.out.println("Enter ID: ");
        int id = in.nextInt();
        ListIterator<Commodity> iterator = commodityList.listIterator();
        while (iterator.hasNext()) {
            if (id == iterator.next().getId()) {
                iterator.set(new Commodity(id, Commands.in.nextLine(), Commands.in.nextDouble(), Commands.in.nextInt()));
            }
        }
    }

   private void sort() {
        System.out.println("Enter sorting order: decrease or increase");
        System.out.println("Warning!!! If you enter anything but these commands the program will sort in increasing order.");
        String order = in.next().toLowerCase();
        System.out.println("Enter field: name, id, price, stock");
        String field = in.next().toLowerCase();

        if (field.equals("name")) {
            if(order.equals(DEFAULT_SORTING_ORDER)){
                commodityList.sort((o1, o2) -> o1.getName().compareTo(o2.getName()));
            }
            else {
                commodityList.sort(((o1, o2) -> o2.getName().compareTo(o1.getName())));
            }
            System.out.println("Sorted");
        }
        if (field.equals("id")) {
            if(order.equals(DEFAULT_SORTING_ORDER)){
                commodityList.sort((o1, o2) -> o1.getId()-o2.getId());
            }
            else {
                commodityList.sort(((o1, o2) -> o2.getId()-o1.getId()));
            }
            System.out.println("Sorted");
        }
        if (field.equals("price")) {
            if(order.equals(DEFAULT_SORTING_ORDER)){
                commodityList.sort(((o1, o2) -> Double.compare(o1.getPrice(),o2.getPrice())));
            }
            else {
                commodityList.sort(((o1, o2) -> Double.compare(o2.getPrice(),o1.getPrice())));
            }
            System.out.println("Sorted");
        }
        if (field.equals("stock")) {
            if(order.equals(DEFAULT_SORTING_ORDER)){
                commodityList.sort((o1, o2) -> o1.getInStock()-o2.getInStock());
            }
            else {
                commodityList.sort((o1, o2) -> o2.getInStock()-o1.getInStock());
            }
            System.out.println("Sorted");
        }
    }


    private void show() {
        for (Commodity commodity : commodityList) {
            System.out.println(commodity);
        }
    }

}

