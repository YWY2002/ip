package Tommy;

import java.io.File;

import Tommy.Command.Command;
import Tommy.Exception.TommyException;
import Tommy.Manager.TaskManager;
import Tommy.Parser.Parser;
import Tommy.Storage.Storage;
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
        boolean isExit = false;

        do {
            userInput = ui.getUserInput();

            if (userInput.isBlank()) {
                continue;
            }

            try {
                Command command = Parser.parse(userInput);
                ui.showLine();
                command.execute(taskManager, ui, storage);
                isExit = command.isExit();
            } catch (TommyException | NumberFormatException | IndexOutOfBoundsException e) {
                ui.showLine();
                ui.showError(e.getMessage());
            }

            if (!isExit) {
                ui.showLine();
            }
        } while (!isExit);

        ui.showGoodbye();
        ui.close();
    }

    public static void main(String[] args) {
        String filePath = "data" + File.separator + "tommy.txt";
        new Tommy(filePath).run();
    }
}
