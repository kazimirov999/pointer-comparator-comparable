package pointer.comparator;

import java.util.Scanner;

public enum Command {
    ADD, REMOVE, UPDATE, SORT, SHOW, HELP, EXIT;

    static Command getCommand(Scanner scanner) {
        try {
            return valueOf(scanner.next().toUpperCase());
        } catch (IllegalArgumentException ex) {
            System.out.println("Wrong command.");
            scanner.nextLine();
            return getCommand(scanner);
        }
    }
}