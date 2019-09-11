package pointer.comparator;

public enum Command {
    ADD, REMOVE, UPDATE, SORT, SHOW, EXIT;

    static Command getCommand(String value) {
        try {
            return valueOf(value.toUpperCase());
        } catch (IllegalArgumentException ex) {
            System.out.println("Wrong command.");
            return Main.getCommandInNextLine();
        }
    }
}
