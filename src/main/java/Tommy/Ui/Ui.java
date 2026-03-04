package Tommy.Ui;
import java.util.Scanner;

public class Ui {
    private Scanner scanner;

    public Ui() {
        this.scanner = new Scanner(System.in);
    }

    public void startupGreetings() {
        System.out.println("---------------------------------------");
        System.out.println("Hello! I'm Tommy, your personal assistant!");
        System.out.println("What can I do for you?");
        System.out.println("Commands: ");
        System.out.println("list -> List all activities");
        System.out.println("mark -> Mark activity as done");
        System.out.println("unmark -> Mark activity as not done");
        System.out.println("todo -> Add activities as todo");
        System.out.println("deadline -> Add activities with deadline");
        System.out.println("/by -> Add activities with deadline");
        System.out.println("event -> Add activities with start and from");
        System.out.println("/from -> Add starting date of event");
        System.out.println("/to -> Add ending date of event");
        System.out.println("---------------------------------------");
    }

    public String getUserInput() {
        if (scanner.hasNextLine()) {
            return scanner.nextLine().trim();
        }
        return "";
    }

    public void showLine() {
        System.out.println("---------------------------------------");
    }

    public void showError(String message) {
        System.out.println(message);
    }

    public void showMessage(String message) {
        System.out.println(message);
    }

    public void showGoodbye() {
        System.out.println("Bye. Hope to see you again soon!");
        System.out.println("---------------------------------------");
    }

    public void showLoadingError() {
        System.out.println("Error loading file.");
    }

    public void close() {
        scanner.close();
    }
}
