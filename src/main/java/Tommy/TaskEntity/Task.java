package Tommy.TaskEntity;
public class Task {
    private Integer taskId;
    private String task;
    private Boolean isDone;

    public Task(Integer taskId, String task, Boolean isDone) {
        setTaskId(taskId);
        setTask(task);
        setIsDone(isDone);
    }

    public void setTaskId(Integer taskId) {
        this.taskId = taskId;
    }
    public Integer getTaskId() {
        return this.taskId;
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
