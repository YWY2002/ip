package Tommy.Command;

import Tommy.Exception.TommyException;
import Tommy.Manager.TaskManager;
import Tommy.Storage.Storage;
import Tommy.Ui.Ui;

public class DeleteCommand extends Command {
    private int index;

    public DeleteCommand(int index) {
        this.index = index;
    }

    //Remove task object from TaskManager array
    @Override
    public void execute(TaskManager tasks, Ui ui, Storage storage) throws TommyException {
        tasks.deleteTask(index);
    }
}
