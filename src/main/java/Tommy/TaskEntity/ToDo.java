package Tommy.TaskEntity;

public class ToDo extends Task {
    public ToDo(String task, Boolean isDone) {
        super(task, isDone);
    }

    @Override
    public String toString() {
        return "[T]" + super.toString();
    }
}
