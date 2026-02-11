package Tommy.TaskEntity;
public class Deadline extends Task {
    protected String by;

    public Deadline(Integer taskId, String task, String by, Boolean isDone) {
        super(taskId, task, isDone);
        this.by = by;
    }

    public void setBy(String by) {
        this.by = by;
    }
    
    public String getBy() {
        return this.by;
    }

    @Override
    public String toString() {
        return "[D]" + super.toString() + " (by: " + by + ")";
    }
}