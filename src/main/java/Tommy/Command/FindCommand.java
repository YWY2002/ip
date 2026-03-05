package Tommy.Command;

import java.util.ArrayList;

import Tommy.Exception.TommyException;
import Tommy.Manager.TaskManager;
import Tommy.Storage.Storage;
import Tommy.TaskEntity.Task;
import Tommy.Ui.Ui;

public class FindCommand extends Command {
    private String keyword;

    public FindCommand(String keyword) {
        this.keyword = keyword;
    }

    //Find task string in TaskManager array, and show results
    @Override
    public void execute(TaskManager tasks, Ui ui, Storage storage) throws TommyException {
        ArrayList<Task> matchingTasks = tasks.findTasks(keyword);
        ui.showMatchingTasks(matchingTasks);
    }
}
