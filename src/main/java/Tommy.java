import java.util.Scanner;
import java.util.ArrayList;

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
        ArrayList<String> inputList = new ArrayList<String>(100);   //creates array object(not list)
 
        do {
            userInput = inputObj.nextLine().trim();
            System.out.println("---------------------------------------");

            if (userInput.equals("list")) {
                if (inputList.size() > 0) {
                    for (int i = 0; i < inputList.size(); i++) {
                        System.out.printf("%d. %s\n", i, inputList.get(i));
                    }
                }
                else {
                    System.out.printf("Your list is empty.");
                }
            }
            else if (!userInput.equals("bye")) {
                inputList.add(userInput);
                System.out.printf("added: %s\n", userInput);
            }

            System.out.println("---------------------------------------");
        } while (!userInput.equalsIgnoreCase("bye"));

        System.out.println("Bye. Hope to see you again soon!");
        System.out.println("---------------------------------------");

    }
}
