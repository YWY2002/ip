public class Event extends Task {
    protected String from;
    protected String to;

    public Event(Integer taskId, String task, String from, String to, Boolean isDone) {
        super(taskId, task, isDone);
        this.from = from;
        this.to = to;
    }

    @Override
    public String toString() {
        return "[E]" + super.toString() + " (from: " + from + " to: " + to + ")";
    }
}