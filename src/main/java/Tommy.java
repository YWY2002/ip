import java.util.Scanner;

public class Tommy {
    public static void main(String[] args) {
        // String logo = " ____        _        \n"
        //         + "|  _ \\ _   _| | _____ \n"
        //         + "| | | | | | | |/ / _ \\\n"
        //         + "| |_| | |_| |   <  __/\n"
        //         + "|____/ \\__,_|_|\\_\\___|\n";
        // System.out.println("Hello from\n" + logo);
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
            String[] parts = userInput.split(" ", 2);
            System.out.println("---------------------------------------");
            String keyword = parts[0].toLowerCase();
            //Keyword: bye, list, mark, unmark
            Task task;

            switch(keyword) {
              case "bye": 
                break;
              case "list": 
                System.out.printf("Here are the tasks in your list:\n");
                taskManager.printAllTask();
                break;
              case "mark":
                task = taskManager.findTask(Integer.parseInt(parts[1]));
                task.setIsDone(true);
                System.out.printf("Nice! I have marked this task as done:\n[X] %s\n", task.getTask());
                break;
              case "unmark":
                task = taskManager.findTask(Integer.parseInt(parts[1]));
                task.setIsDone(false);
                System.out.printf("Nice! I have marked this task as not done yet:\n[ ] %s\n", task.getTask());
                break;
              default:
                String taskString = String.join(" ", parts);
                taskManager.addTask(counter+1, taskString, false);
                counter++;
                break;
            }
            
            System.out.println("---------------------------------------");
        } while (!userInput.equalsIgnoreCase("bye"));

        System.out.println("Bye. Hope to see you again soon!");
        System.out.println("---------------------------------------");

    }
}
