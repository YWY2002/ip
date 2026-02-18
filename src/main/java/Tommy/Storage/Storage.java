package Tommy.Storage;

import Tommy.TaskEntity.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Storage {
    private String filePath;

    public Storage(String filePath) {
        this.filePath = filePath;
    }

    // Load data from file
    public ArrayList<Task> load() {
        ArrayList<Task> tasks = new ArrayList<>();
        File f = new File(filePath);

        // 1. Handle missing file/directory
        if (!f.exists()) {
            return tasks; // Return empty list if file doesn't exist yet
        }

        // 2. Read and Parse
        try (Scanner scanner = new Scanner(f)) {
            while (scanner.hasNext()) {
                String line = scanner.nextLine();
                try {
                    Task task = parseLineToTask(line);
                    if (task != null) {
                        tasks.add(task);
                    }
                } catch (Exception e) {
                    System.out.println("Skipping corrupted line: " + line);
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }

        return tasks;
    }

    // Save data to file
    public void save(ArrayList<Task> tasks) {
        // Ensure directory exists before writing
        File f = new File(filePath);
        if (!f.getParentFile().exists()) {
            f.getParentFile().mkdirs();
        }

        try (FileWriter fw = new FileWriter(filePath)) {
            for (Task t : tasks) {
                fw.write(formatTaskForFile(t) + System.lineSeparator());
            }
        } catch (IOException e) {
            System.out.println("Error saving tasks: " + e.getMessage());
        }
    }

    // Helper: Convert File String -> Task Object
    private Task parseLineToTask(String line) {
        // Expected format: T | 1 | description
        String[] parts = line.split(" \\| "); 
        String type = parts[0];
        boolean isDone = parts[1].equals("1");
        String description = parts[2];
        
        // We use a temporary ID of 0; the Manager will reassign IDs later or we just track index
        int tempId = 0; 

        switch (type) {
            case "T":
                return new ToDo(tempId, description, isDone);
            case "D":
                // Format: D | 0 | return book | June 6th
                return new Deadline(tempId, description, parts[3], isDone);
            case "E":
                // Format: E | 0 | meeting | Mon 2pm | 4pm
                return new Event(tempId, description, parts[3], parts[4], isDone);
            default:
                throw new IllegalArgumentException("Unknown task type");
        }
    }

    // Helper: Convert Task Object -> File String
    private String formatTaskForFile(Task t) {
        String status = t.getIsDone() ? "1" : "0";
        String type = "";
        String extra = "";

        // Determine type and specific fields
        if (t instanceof ToDo) {
            type = "T";
        } else if (t instanceof Deadline) {
            type = "D";
            extra = " | " + ((Deadline) t).getBy(); 
        } else if (t instanceof Event) {
            type = "E";
            extra = " | " + ((Event) t).getFrom() + " | " + ((Event) t).getTo();
        }

        // Uses t.getTask() based on your Task.java
        return type + " | " + status + " | " + t.getTask() + extra;
    }
}