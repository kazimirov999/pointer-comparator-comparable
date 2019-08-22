package pointer.comparator;

import java.util.Scanner;

public enum Command {
    ADD, REMOVE, UPDATE, SORT, SHOW, EXIT;

    static Command getCommand(Scanner scanner) {
        return Command.valueOf(scanner.next().toUpperCase());
    }

    static Command getNextCommand(Scanner scanner) {
        scanner.nextLine();
        return getCommand(scanner);
    }
}
