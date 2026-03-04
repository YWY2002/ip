package Tommy.Command;

import Tommy.Exception.TommyException;
import Tommy.Manager.TaskManager;
import Tommy.Storage.Storage;
import Tommy.Ui.Ui;

public class ExitCommand extends Command {
    @Override
    public void execute(TaskManager tasks, Ui ui, Storage storage) throws TommyException {
        // Nothing to execute for exit, but we keep it for consistency.
    }

    @Override
    public boolean isExit() {
        return true;
    }
}
