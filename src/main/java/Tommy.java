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
            userInput = inputObj.nextLine().trim();
            // Split command word from the rest of the sentence
            String[] parts = userInput.split(" ", 2); 
            String keyword = parts[0].toLowerCase();
            String arguments = (parts.length > 1) ? parts[1] : "";

            System.out.println("---------------------------------------");
            
            Task task;

            switch(keyword) {
                case "bye": 
                    break;

                case "list": 
                    System.out.printf("Here are the tasks in your list:\n");
                    taskManager.printAllTask();
                    break;

                case "mark":
                    task = taskManager.findTask(Integer.parseInt(arguments));
                    if (task != null) {
                        task.setIsDone(true);
                        System.out.printf("Nice! I have marked this task as done:\n%s\n", task.toString());
                    }
                    break;

                case "unmark":
                    task = taskManager.findTask(Integer.parseInt(arguments));
                    if (task != null) {
                        task.setIsDone(false);
                        System.out.printf("Nice! I have marked this task as not done yet:\n%s\n", task.toString());
                    }
                    break;

                case "todo":
                    counter++;
                    // arguments contains the description
                    ToDo newTodo = new ToDo(counter, arguments, false);
                    taskManager.addTask(newTodo);
                    break;

                case "deadline":
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
                    System.out.println("I'm sorry, but I don't know what that means :-(");
                    break;
            }
            
            System.out.println("---------------------------------------");
        } while (!userInput.equalsIgnoreCase("bye"));

        System.out.println("Bye. Hope to see you again soon!");
        System.out.println("---------------------------------------");
    }
}