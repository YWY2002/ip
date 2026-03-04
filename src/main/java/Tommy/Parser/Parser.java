package Tommy.Parser;

import Tommy.Exception.TommyException;
import java.util.List;

public class Parser {

    public static String[] parseCommand(String userInput) {
        return userInput.trim().split(" ", 2);
    }

    public static void validateTask(String args) throws TommyException {
        if (args == null || args.isBlank()) {
            throw new TommyException("Please specify a task.");
        }
    }

    public static void validateCommand(String args) throws TommyException {
        Boolean isValid = false;
        List<String> commandList = List.of("bye", "list", "mark", "unmark", "todo", "deadline", "event", "delete");

        if (args == null || args.isBlank()) {
            throw new TommyException("Please enter a command!");
        }
        for (String command : commandList) {
            if (command.equalsIgnoreCase(args)) {
                isValid = true;
                break;
            }
        }
        if (isValid == false) {
            throw new TommyException("Please use a valid command!");
        }
    }

    public static void validateDeadline(String[] argsArray) throws TommyException {
        if (argsArray.length < 2 || argsArray[1].isBlank()) {
            throw new TommyException("Please enter a deadline!");
        }
    }
}
