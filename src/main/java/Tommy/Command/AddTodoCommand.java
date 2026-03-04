package Tommy.Command;

import Tommy.Exception.TommyException;
import Tommy.Manager.TaskManager;
import Tommy.Storage.Storage;
import Tommy.TaskEntity.ToDo;
import Tommy.Ui.Ui;

public class AddTodoCommand extends Command {
    private String description;

    public AddTodoCommand(String description) {
        this.description = description;
    }

    @Override
    public void execute(TaskManager tasks, Ui ui, Storage storage) throws TommyException {
        ToDo newTodo = new ToDo(description, false);
        tasks.addTask(newTodo);
    }
}
