package Tommy.Command;

import Tommy.Exception.TommyException;
import Tommy.Manager.TaskManager;
import Tommy.Storage.Storage;
import Tommy.Ui.Ui;

public abstract class Command {
    public abstract void execute(TaskManager tasks, Ui ui, Storage storage) throws TommyException;

    public boolean isExit() {
        return false;
    }
}
