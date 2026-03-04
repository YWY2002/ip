package Tommy.Command;

import Tommy.Exception.TommyException;
import Tommy.Manager.TaskManager;
import Tommy.Storage.Storage;
import Tommy.TaskEntity.Deadline;
import Tommy.Ui.Ui;

public class AddDeadlineCommand extends Command {
    private String description;
    private String by;

    public AddDeadlineCommand(String description, String by) {
        this.description = description;
        this.by = by;
    }

    @Override
    public void execute(TaskManager tasks, Ui ui, Storage storage) throws TommyException {
        tasks.addTask(new Deadline(description, by, false));
    }
}
