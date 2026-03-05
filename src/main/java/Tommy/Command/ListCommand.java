package Tommy.Command;

import Tommy.Exception.TommyException;
import Tommy.Manager.TaskManager;
import Tommy.Storage.Storage;
import Tommy.Ui.Ui;

public class ListCommand extends Command {
    //Show all task from data/tommy.txt
    @Override
    public void execute(TaskManager tasks, Ui ui, Storage storage) throws TommyException {
        ui.showMessage("Here are the tasks in your list:");
        tasks.printAllTask();
    }
}
