package Tommy.Parser;

import Tommy.Exception.TommyException;
import Tommy.Command.*;

public class Parser {

    public static Command parse(String userInput) throws TommyException {
        String[] parts = userInput.trim().split(" ", 2);
        String command = parts[0].toLowerCase();
        String arguments = (parts.length > 1) ? parts[1] : "";

        switch (command) {
            case "bye":
                return new ExitCommand();

            case "list":
                return new ListCommand();

            case "mark":
                validateTask(arguments);
                return new MarkCommand(Integer.parseInt(arguments), true);

            case "unmark":
                validateTask(arguments);
                return new MarkCommand(Integer.parseInt(arguments), false);

            case "todo":
                validateTask(arguments);
                return new AddTodoCommand(arguments);

            case "deadline":
                validateTask(arguments);
                String[] dParts = arguments.split(" /by ");
                validateDeadline(dParts);
                return new AddDeadlineCommand(dParts[0], dParts[1]);

            case "event":
                validateTask(arguments);
                int fromIndex = arguments.indexOf(" /from ");
                int toIndex = arguments.indexOf(" /to ");
                if (fromIndex == -1 || toIndex == -1)
                    throw new TommyException("Invalid format. Use /from and /to");

                String eventDesc = arguments.substring(0, fromIndex);
                String from = arguments.substring(fromIndex + 7, toIndex);
                String to = arguments.substring(toIndex + 5);
                return new AddEventCommand(eventDesc, from, to);

            case "delete":
                validateTask(arguments);
                int deleteTaskId = Integer.parseInt(arguments);
                return new DeleteCommand(deleteTaskId);

            default:
                throw new TommyException("Please use a valid command!");
        }
    }

    private static void validateTask(String args) throws TommyException {
        if (args == null || args.isBlank()) {
            throw new TommyException("Please specify a task.");
        }
    }

    private static void validateDeadline(String[] argsArray) throws TommyException {
        if (argsArray.length < 2 || argsArray[1].isBlank()) {
            throw new TommyException("Please enter a deadline!");
        }
    }
}
