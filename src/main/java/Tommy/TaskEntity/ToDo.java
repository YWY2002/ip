package Tommy.TaskEntity;
public class ToDo extends Task {
    public ToDo(Integer taskId, String task, Boolean isDone) {
        super(taskId, task, isDone);
    }

    @Override
    public String toString() {
        return "[T]" + super.toString();
    }
}
