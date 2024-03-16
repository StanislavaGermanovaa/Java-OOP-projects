package TaskManage;

import java.util.ArrayList;
import java.util.Scanner;

class Task {
    private String title;
    private String description;

    public Task(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }
}

class TaskManager {
    private ArrayList<Task> tasks;

    public TaskManager() {
        tasks = new ArrayList<>();
    }

    public void addTask(Task task) {
        tasks.add(task);
    }

    public void deleteTask(int index) {
        if (index >= 0 && index < tasks.size()) {
            tasks.remove(index);
        } else {
            System.out.println("Invalid task index!");
        }
    }

    public void displayTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks found!");
        } else {
            System.out.println("Tasks:");
            for (int i = 0; i < tasks.size(); i++) {
                Task task = tasks.get(i);
                System.out.println((i + 1) + ". " + task.getTitle() + " - " + task.getDescription());
            }
        }
    }
}

public class TaskManage {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TaskManager taskManager = new TaskManager();

        while (true) {
            System.out.println("TaskManage.Task Manager Menu:");
            System.out.println("1. Add TaskManage.Task");
            System.out.println("2. Delete TaskManage.Task");
            System.out.println("3. Display Tasks");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter task title: ");
                    scanner.nextLine();
                    String title = scanner.nextLine();
                    System.out.print("Enter task description: ");
                    String description = scanner.nextLine();
                    taskManager.addTask(new Task(title, description));
                    break;
                case 2:
                    System.out.print("Enter task index to delete: ");
                    int index = scanner.nextInt();
                    taskManager.deleteTask(index - 1); // Adjust index to match ArrayList indexing
                    break;
                case 3:
                    taskManager.displayTasks();
                    break;
                case 4:
                    System.out.println("Exiting TaskManage.Task Manager. Goodbye!");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice! Please enter a number between 1 and 4.");
            }
        }
    }
}