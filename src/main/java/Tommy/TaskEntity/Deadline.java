package Tommy.TaskEntity;

public class Deadline extends Task {
    private String by;

    public Deadline(String task, String by, Boolean isDone) {
        super(task, isDone);
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