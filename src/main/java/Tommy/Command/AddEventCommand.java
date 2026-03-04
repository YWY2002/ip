package Tommy.Command;

import Tommy.Exception.TommyException;
import Tommy.Manager.TaskManager;
import Tommy.Storage.Storage;
import Tommy.TaskEntity.Event;
import Tommy.Ui.Ui;

public class AddEventCommand extends Command {
    private String description;
    private String from;
    private String to;

    public AddEventCommand(String description, String from, String to) {
        this.description = description;
        this.from = from;
        this.to = to;
    }

    @Override
    public void execute(TaskManager tasks, Ui ui, Storage storage) throws TommyException {
        tasks.addTask(new Event(description, from, to, false));
    }
}
