import java.util.ArrayList;

public class TaskManager {
    private ArrayList<Task> taskList;

    public TaskManager() {
        this.taskList = new ArrayList<Task>();
    }

    public void addTask(Integer taskId, String task, Boolean isDone) {
        Task newTask = new Task(taskId, task, isDone);
        taskList.add(newTask);
        System.out.printf("Task added: \nTaskID: %d\nTask: %s\n", taskId, task);
    }

    public void printAllTask() {
        if (taskList.size() == 0) {
            System.out.printf("Your list is empty.\n");
        }
        else {
            for (Task t: taskList) {
                if (taskList.size() > 0) {
                    
                    if (t.getIsDone().equals(true)){
                        System.out.printf("%d. [X] %s\n", t.getTaskId(), t.getTask());
                    }
                    else {
                        System.out.printf("%d. [ ] %s\n", t.getTaskId(), t.getTask());
                    }
                }

            }
        }

    }

    public Task findTask(Integer taskId) {
        for (Task t: taskList) {
            if (t.getTaskId().equals(taskId)) {
                return t;
            }
        }
        return null;
    }
}
