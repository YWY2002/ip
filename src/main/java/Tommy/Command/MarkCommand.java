package Tommy.Command;

import Tommy.Exception.TommyException;
import Tommy.Manager.TaskManager;
import Tommy.Storage.Storage;
import Tommy.Ui.Ui;

public class MarkCommand extends Command {
    private int index;
    private boolean isMark;

    public MarkCommand(int index, boolean isMark) {
        this.index = index;
        this.isMark = isMark;
    }

    @Override
    public void execute(TaskManager tasks, Ui ui, Storage storage) throws TommyException {
        tasks.markTask(index, isMark);
    }
}
