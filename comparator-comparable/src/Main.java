

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException, InterruptedException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        CommodytyManager commodytyManager = new CommodytyManager();

        commodytyManager.commodities.add(new Commodity("Braun", 5800, 2));
        commodytyManager.commodities.add(new Commodity("Philips", 6300, 1));
        commodytyManager.commodities.add(new Commodity("Sony", 3500, 4));
        commodytyManager.commodities.add(new Commodity("Delongi", 4500, 3));
        commodytyManager.commodities.add(new Commodity("Alpari", 2800, 5));

        System.out.println("1. added  Commodity to list " + "\n" +
                "2. remove Commodity from list " + "\n" +
                "3. change Commodity in list " + "\n" +
                "4. sort by: ");
        while (true) {
            String input = reader.readLine();
            if (input.equals("0")) {
                break;
            } else {
                switch (input) {
                    case "1":
                        commodytyManager.addCommodity();
                        commodytyManager.showCommodity();
                        break;
                    case "2":
                        commodytyManager.removeCommodity();
                        commodytyManager.showCommodity();
                        break;
                    case "3":
                        commodytyManager.changeCommodity();
                        commodytyManager.showCommodity();
                        break;
                    case "4":
                        System.out.println("1. sorted by brand " + "\n" +
                                "2. sorted by price " + "\n" +
                                "3. sorted by popularity " + "\n" +
                                "0. back to main menu ");
                        switch (reader.readLine()) {
                            case "1":
                                commodytyManager.commodities.sort(new SortedByBrand());
                                commodytyManager.showCommodity();
                                break;
                            case "2":
                                commodytyManager.commodities.sort(new SortedByPrice());
                                commodytyManager.showCommodity();
                                break;
                            case "3":
                                commodytyManager.commodities.sort(new SortedByPopularity());
                                commodytyManager.showCommodity();
                                break;
                        }
                        break;
                    case "0":
                        break;
                    case "5" :
                        System.console().format("\\x1b[2J\\x1b[H");
                        break;
                    default:
                        System.out.println("1. added  Commodity to list " + "\n" +
                                "2. remove Commodity from list " + "\n" +
                                "3. change Commodity in list " + "\n" +
                                "4. sort by: ");
                        break;
                }
            }

        }
    }
}
