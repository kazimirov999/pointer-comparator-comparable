package com.pointer.comparable;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {


        ArrayList<Commodity> commodities = new ArrayList<Commodity>();
        commodities.add(new Commodity(0, "Vodka", 99, 0));
        commodities.add(new Commodity(0, "Beer", 20, 100));
        CommodityManager commodityManager = new CommodityManager(commodities);
        commodityManager.startMenu();

    }
}
