package Tommy.TaskEntity;

public class Task {
    private String task;
    private Boolean isDone;

    public Task(String task, Boolean isDone) {
        setTask(task);
        setIsDone(isDone);
    }

    public void setTask(String task) {
        this.task = task;
    }

    public String getTask() {
        return this.task;
    }

    public void setIsDone(Boolean isDone) {
        this.isDone = isDone;
    }

    public Boolean getIsDone() {
        return this.isDone;
    }

    // Help with printing the status icon
    public String getStatusIcon() {
        return (isDone ? "[X]" : "[ ]");
    }

    // Base toString method
    @Override
    public String toString() {
        return getStatusIcon() + " " + task;
    }
}
