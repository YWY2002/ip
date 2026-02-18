package Tommy.Manager;
import java.util.ArrayList;

import Tommy.Storage.Storage;
import Tommy.TaskEntity.*;

public class TaskManager {
    private ArrayList<Task> taskList;
    private Storage storage;

    public TaskManager(Storage storage) {
        this.storage = storage;
        this.taskList = storage.load(); // Load from disk on startup

        // Re-assign IDs based on current list order to keep them sequential
        for (int i = 0; i < taskList.size(); i++) {
            taskList.get(i).setTaskId(i + 1);
        }
    }

    public int getTaskCount() {
        return taskList.size();
    }

    //Accept any object that inherits from Task
    public void addTask(Task newTask) {
        taskList.add(newTask);
        storage.save(taskList);
        System.out.println("Got it. I've added this task:");
        System.out.println("  " + newTask.toString());
        System.out.println("Now you have " + taskList.size() + " tasks in the list.");
    }

    public void markTask(int taskId, boolean isDone) {
        Task task = findTask(taskId);
        if (task != null) {
            task.setIsDone(isDone);
            storage.save(taskList); // Auto-save
            
            String status = isDone ? "done" : "not done yet";
            System.out.printf("Nice! I have marked this task as %s:\n%s\n", status, task.toString());
        }
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