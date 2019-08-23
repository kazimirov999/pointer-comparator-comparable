package pointer.comparator;

import java.util.Scanner;

public enum Command {
    ADD, REMOVE, UPDATE, SORT, SHOW, EXIT;

    static Command getCommand(Scanner scanner) {
        try {
            return Command.valueOf(scanner.next().toUpperCase());
        } catch (IllegalArgumentException ex) {
            System.out.println("Wrong command.");
            return getNextCommand(scanner);
        }

    }

    static Command getNextCommand(Scanner scanner) {
        scanner.nextLine();
        return getCommand(scanner);
    }
}
