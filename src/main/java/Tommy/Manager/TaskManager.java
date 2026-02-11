import java.util.ArrayList;

public class TaskManager {
    private ArrayList<Task> taskList;

    public TaskManager() {
        this.taskList = new ArrayList<Task>();
    }

    //Accept any object that inherits from Task
    public void addTask(Task newTask) {
        taskList.add(newTask);
        System.out.println("Got it. I've added this task:");
        System.out.println("  " + newTask.toString());
        System.out.println("Now you have " + taskList.size() + " tasks in the list.");
    }

    public void printAllTask() {
        if (taskList.size() == 0) {
            System.out.printf("Your list is empty.\n");
        } else {
            for (Task t : taskList) {
                // Using t.toString() automatically checks if it is a ToDo, Deadline, or Event
                // and prints the correct format ([T], [D], or [E])
                System.out.printf("%d.%s\n", t.getTaskId(), t.toString());
            }
        }
    }

    public Task findTask(Integer taskId) {
        for (Task t : taskList) {
            if (t.getTaskId().equals(taskId)) {
                return t;
            }
        }
        return null;
    }
}