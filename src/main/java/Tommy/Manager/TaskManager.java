package Tommy.Manager;

import java.util.ArrayList;
import Tommy.TaskEntity.*;

import Tommy.Storage.Storage;
import Tommy.TaskEntity.*;

public class TaskManager {
    private ArrayList<Task> taskList;
    private Storage storage;

    public TaskManager(Storage storage) {
        this.storage = storage;
        this.taskList = storage.load(); // Load from disk on startup
    }

    public int getTaskCount() {
        return taskList.size();
    }

    // Accept any object that inherits from Task
    public void addTask(Task newTask) {
        taskList.add(newTask);
        storage.save(taskList);
        System.out.println("Got it. I've added this task:");
        System.out.println("  " + newTask.toString());
        System.out.println("Now you have " + taskList.size() + " tasks in the list.");
    }

    public void markTask(int index, boolean isDone) {
        if (index > 0 && index <= taskList.size()) {
            Task task = taskList.get(index - 1);
            task.setIsDone(isDone);
            storage.save(taskList); // Auto-save

            String status = isDone ? "done" : "not done yet";
            System.out.printf("Nice! I have marked this task as %s:\n%s\n", status, task.toString());
        } else {
            System.out.println("Invalid task index.");
        }
    }

    public void deleteTask(int index) {
        if (index > 0 && index <= taskList.size()) {
            Task task = taskList.remove(index - 1);
            System.out.println("The following task has been removed:");
            System.out.printf("%d.%s\n", index, task.toString());
            storage.save(taskList);
        } else {
            System.out.println("Task is not found. Please enter again.");
        }
    }

    public int length() {
        return taskList.size();
    }

    public void printAllTask() {
        if (taskList.size() == 0) {
            System.out.printf("Your list is empty.\n");
        } else {
            for (int i = 0; i < taskList.size(); i++) {
                Task t = taskList.get(i);
                // Using t.toString() automatically checks if it is a ToDo, Deadline, or Event
                // and prints the correct format ([T], [D], or [E])
                System.out.printf("%d.%s\n", i + 1, t.toString());
            }
        }
    }
}