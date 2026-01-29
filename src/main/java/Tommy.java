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
        do {
            userInput = inputObj.nextLine().trim();
            System.out.println("---------------------------------------");
            if (userInput != "bye") {
                System.out.println(userInput);
            }
            System.out.println("---------------------------------------");
        } while (!userInput.equalsIgnoreCase("bye"));

        System.out.println("Bye. Hope to see you again soon!");
        System.out.println("---------------------------------------");

    }
}
