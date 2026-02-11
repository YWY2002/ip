import java.util.List;
import java.util.Scanner;

public class Tommy {
    public static void main(String[] args) {
        System.out.println("---------------------------------------");
        System.out.println("Hello! I'm Tommy, your personal assistant!");
        System.out.println("What can I do for you?");
        System.out.println("---------------------------------------");
        
        Scanner inputObj = new Scanner(System.in);
        String userInput = "";
        int counter = 0;
        TaskManager taskManager = new TaskManager();

        do {
            // userInput = inputObj.nextLine().trim();
            // Split command word from the rest of the sentence
            try {
                userInput = inputObj.nextLine().trim();
                String[] parts = userInput.split(" ", 2); 
                String command = parts[0].toLowerCase();
                String arguments = (parts.length > 1) ? parts[1] : "";

                System.out.println("---------------------------------------");
                
                Task task;
                validateCommand(command);
                validateTask(arguments);
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
                        if (task != null) {
                            task.setIsDone(true);
                            System.out.printf("Nice! I have marked this task as done:\n%s\n", task.toString());
                        }
                        break;
    
                    case "unmark":
                        validateTask(arguments);
                        task = taskManager.findTask(Integer.parseInt(arguments));
                        if (task != null) {
                            task.setIsDone(false);
                            System.out.printf("Nice! I have marked this task as not done yet:\n%s\n", task.toString());
                        }
                        break;
    
                    case "todo":
                        validateTask(arguments);
                        counter++;
                        // arguments contains the description
                        ToDo newTodo = new ToDo(counter, arguments, false);
                        taskManager.addTask(newTodo);
                        break;
    
                    case "deadline":
                        validateTask(arguments);
                        counter++;
                        // Split by " /by "
                        // Example: "return book /by Sunday"
                        String[] deadlineParts = arguments.split(" /by ");
                        String deadlineDesc = deadlineParts[0];
                        String by = deadlineParts[1];
                        
                        Deadline newDeadline = new Deadline(counter, deadlineDesc, by, false);
                        taskManager.addTask(newDeadline);
                        break;
    
                    case "event":
                        validateTask(arguments);
                        counter++;
                        // Split by " /from " and " /to "
                        // Example: "project meeting /from Mon 2pm /to 4pm"
                        int fromIndex = arguments.indexOf(" /from ");
                        int toIndex = arguments.indexOf(" /to ");
                        
                        String eventDesc = arguments.substring(0, fromIndex);
                        String from = arguments.substring(fromIndex + 7, toIndex);
                        String to = arguments.substring(toIndex + 5);
    
                        Event newEvent = new Event(counter, eventDesc, from, to, false);
                        taskManager.addTask(newEvent);
                        break;
    
                    default:
                        validateCommand(command);
                        break;
                }
            } catch (TommyException e) {
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
        List<String> commandList = List.of("bye", "list", "mark", "unmark", "todo", "deadline", "event");

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
}