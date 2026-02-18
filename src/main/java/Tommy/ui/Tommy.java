package Tommy.ui;
import java.io.File;
import java.util.List;
import java.util.Scanner;

import Tommy.Exception.TommyException;
import Tommy.TaskEntity.Deadline;
import Tommy.TaskEntity.Event;
import Tommy.TaskEntity.Task;
import Tommy.TaskEntity.ToDo;
import Tommy.Manager.TaskManager;
import Tommy.Storage.Storage;

public class Tommy {
    public static void main(String[] args) {
        System.out.println("---------------------------------------");
        System.out.println("Hello! I'm Tommy, your personal assistant!");
        System.out.println("What can I do for you?");
        System.out.println("---------------------------------------");
        
        Scanner inputObj = new Scanner(System.in);
        String userInput = "";
        String filePath = "data" + File.separator + "tommy.txt";
        Storage storage = new Storage(filePath);
        TaskManager taskManager = new TaskManager(storage);

        do {
            // userInput = inputObj.nextLine().trim();
            // Split command word from the rest of the sentence
            try {
                userInput = inputObj.nextLine().trim();
                String[] parts = userInput.split(" ", 2); 
                String command = parts[0].toLowerCase();
                String arguments = (parts.length > 1) ? parts[1] : "";
                int counter = taskManager.getTaskCount();

                System.out.println("---------------------------------------");
                
                Task task;
                Integer taskId = taskManager.length() + 1;

                validateCommand(command);
                switch(command) {
                    case "bye": 
                        break;
    
                    case "list": 
                        System.out.printf("Here are the tasks in your list:\n");
                        taskManager.printAllTask();
                        break;
    
                    case "mark":
                        validateTask(arguments);
                        task = taskManager.findTask(Integer.parseInt(arguments));
                        taskManager.markTask(Integer.parseInt(arguments), true);
                        break;
    
                    case "unmark":
                        validateTask(arguments);
                        taskManager.markTask(Integer.parseInt(arguments), false);
                        break;
    
                    case "todo":
                        validateTask(arguments);
                        // arguments contains the description
                        ToDo newTodo = new ToDo(taskId, arguments, false);
                        taskManager.addTask(newTodo);
                        break;
    
                    case "deadline":
                        validateTask(arguments);
                        // Split by " /by "
                        // Example: "return book /by Sunday"
                        String[] dParts = arguments.split(" /by ");
                        if (dParts.length < 2) throw new TommyException("Use /by for deadlines");
                        taskManager.addTask(new Deadline(counter, dParts[0], dParts[1], false));
                        break;
    
                    case "event":
                        validateTask(arguments);
                        // Split by " /from " and " /to "
                        // Example: "project meeting /from Mon 2pm /to 4pm"
                        int fromIndex = arguments.indexOf(" /from ");
                        int toIndex = arguments.indexOf(" /to ");
                        if(fromIndex == -1 || toIndex == -1) throw new TommyException("Invalid format. Use /from and /to");

                        String eventDesc = arguments.substring(0, fromIndex);
                        String from = arguments.substring(fromIndex + 7, toIndex);
                        String to = arguments.substring(toIndex + 5);
    
                        Event newEvent = new Event(taskId, eventDesc, from, to, false);
                        taskManager.addTask(newEvent);
                        break;
                    
                    case "delete":
                        validateTask(arguments);
                        int deleteTaskId = Integer.parseInt(arguments);
                        taskManager.deleteTask(deleteTaskId);
                        break;
                    default:
                        validateCommand(command);
                        break;
                }
            } catch (TommyException | NumberFormatException | IndexOutOfBoundsException e) {
                System.out.println(e.getMessage());
            }
            System.out.println("---------------------------------------");
        } while (!userInput.equalsIgnoreCase("bye"));

        System.out.println("Bye. Hope to see you again soon!");
        System.out.println("---------------------------------------");
        inputObj.close();
    }

    private static void validateTask(String args) throws TommyException {
        if (args.isBlank()) {
            throw new TommyException("Please specify a task.");
        }
    }
    private static void validateCommand(String args) throws TommyException {
        Boolean isValid = false;
        List<String> commandList = List.of("bye", "list", "mark", "unmark", "todo", "deadline", "event", "delete");

        if (args.isBlank()) {
            throw new TommyException("Please enter a command!");
        }
        for (String command: commandList) {
            if (command.equalsIgnoreCase(args)) {
                isValid = true;
                break;
            }
        }
        if (isValid == false) {
            throw new TommyException("Please use a valid command!");
        }
    }
    // TODO validate other task type
    private static void validateDeadline(String[] argsArray) throws TommyException {
        if (argsArray[1].isBlank()) {
            throw new TommyException("Please enter a deadline!");
        }
    }
}