package Tommy;

import java.io.File;

import Tommy.Exception.TommyException;
import Tommy.TaskEntity.Deadline;
import Tommy.TaskEntity.Event;
import Tommy.TaskEntity.Task;
import Tommy.TaskEntity.ToDo;
import Tommy.Manager.TaskManager;
import Tommy.Storage.Storage;
import Tommy.Parser.Parser;
import Tommy.Ui.Ui;

public class Tommy {
    private Storage storage;
    private TaskManager taskManager;
    private Ui ui;

    public Tommy(String filePath) {
        ui = new Ui();
        storage = new Storage(filePath);
        taskManager = new TaskManager(storage);
    }

    public void run() {
        ui.startupGreetings();
        String userInput;

        do {
            userInput = ui.getUserInput();

            if (userInput.isBlank()) {
                continue;
            }

            try {
                String[] parts = Parser.parseCommand(userInput);
                String command = parts[0].toLowerCase();
                String arguments = (parts.length > 1) ? parts[1] : "";

                ui.showLine();
                Parser.validateCommand(command);

                int counter = taskManager.getTaskCount();
                Task task;
                Integer taskId = taskManager.length() + 1;

                switch (command) {
                    case "bye":
                        break;

                    case "list":
                        ui.showMessage("Here are the tasks in your list:");
                        taskManager.printAllTask();
                        break;

                    case "mark":
                        Parser.validateTask(arguments);
                        task = taskManager.findTask(Integer.parseInt(arguments));
                        taskManager.markTask(Integer.parseInt(arguments), true);
                        break;

                    case "unmark":
                        Parser.validateTask(arguments);
                        taskManager.markTask(Integer.parseInt(arguments), false);
                        break;

                    case "todo":
                        Parser.validateTask(arguments);
                        ToDo newTodo = new ToDo(taskId, arguments, false);
                        taskManager.addTask(newTodo);
                        break;

                    case "deadline":
                        Parser.validateTask(arguments);
                        String[] dParts = arguments.split(" /by ");
                        Parser.validateDeadline(dParts);
                        taskManager.addTask(new Deadline(counter, dParts[0], dParts[1], false));
                        break;

                    case "event":
                        Parser.validateTask(arguments);
                        int fromIndex = arguments.indexOf(" /from ");
                        int toIndex = arguments.indexOf(" /to ");
                        if (fromIndex == -1 || toIndex == -1)
                            throw new TommyException("Invalid format. Use /from and /to");

                        String eventDesc = arguments.substring(0, fromIndex);
                        String from = arguments.substring(fromIndex + 7, toIndex);
                        String to = arguments.substring(toIndex + 5);

                        Event newEvent = new Event(taskId, eventDesc, from, to, false);
                        taskManager.addTask(newEvent);
                        break;

                    case "delete":
                        Parser.validateTask(arguments);
                        int deleteTaskId = Integer.parseInt(arguments);
                        taskManager.deleteTask(deleteTaskId);
                        break;
                    default:
                        Parser.validateCommand(command);
                        break;
                }
            } catch (TommyException | NumberFormatException | IndexOutOfBoundsException e) {
                ui.showError(e.getMessage());
            }
            if (!userInput.equalsIgnoreCase("bye")) {
                ui.showLine();
            }
        } while (!userInput.equalsIgnoreCase("bye"));

        ui.showGoodbye();
        ui.close();
    }

    public static void main(String[] args) {
        String filePath = "data" + File.separator + "tommy.txt";
        new Tommy(filePath).run();
    }
}
