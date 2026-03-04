package Tommy.TaskEntity;

public class Event extends Task {
    private String from;
    private String to;

    public Event(String task, String from, String to, Boolean isDone) {
        super(task, isDone);
        this.from = from;
        this.to = to;
    }

    @Override
    public String toString() {
        return "[E]" + super.toString() + " (from: " + from + " to: " + to + ")";
    }

    public String getFrom() {
        return this.from;
    }

    public String getTo() {
        return this.to;
    }
}