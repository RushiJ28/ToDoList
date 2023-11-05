import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Task {
    private String description;
    private boolean isCompleted;
    private String dueDate;

    public Task(String description, String dueDate) {
        this.description = description;
        this.isCompleted = false;
        this.dueDate = dueDate;
    }

    public String getDescription() {
        return description;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void markAsCompleted() {
        isCompleted = true;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }
}

class ToDoList {
    private List<Task> tasks;

    public ToDoList() {
        tasks = new ArrayList<>();
    }

    public void addTask(String description, String dueDate) {
        Task task = new Task(description, dueDate);
        tasks.add(task);
    }

    public void markTaskAsCompleted(int taskIndex) {
        if (taskIndex >= 0 && taskIndex < tasks.size()) {
            Task task = tasks.get(taskIndex);
            task.markAsCompleted();
        }
    }

    public void listTasks() {
        for (int i = 0; i < tasks.size(); i++) {
            Task task = tasks.get(i);
            String status = task.isCompleted() ? "Completed" : "Not Completed";
            System.out.println(i + ". " + task.getDescription() + " - Due: " + task.getDueDate() + " - " + status);
        }
    }

    public Task getTask(int taskIndex) {
        if (taskIndex >= 0 && taskIndex < tasks.size()) {
            return tasks.get(taskIndex);
        }
        return null;
    }

    public void editTask(int taskIndex, String newDescription, String newDueDate) {
        Task task = getTask(taskIndex);
        if (task != null) {
            task.setDescription(newDescription);
            task.setDueDate(newDueDate);
        }
    }

    public void deleteTask(int taskIndex) {
        if (taskIndex >= 0 && taskIndex < tasks.size()) {
            tasks.remove(taskIndex);
        }
    }
}

public class ToDoListJ {
    public static void main(String[] args) {
        ToDoList toDoList = new ToDoList();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Add Task");
            System.out.println("2. Mark Task as Completed");
            System.out.println("3. List Tasks");
            System.out.println("4. Edit Task");
            System.out.println("5. Delete Task");
            System.out.println("6. Quit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            if (choice == 1) {
                System.out.print("Enter task description: ");
                scanner.nextLine();  // Consume the newline character
                String description = scanner.nextLine();
                System.out.print("Enter due date: ");
                String dueDate = scanner.nextLine();
                toDoList.addTask(description, dueDate);
            } else if (choice == 2) {
                toDoList.listTasks(); // List tasks along with their indices
                System.out.print("Enter the index of the task to mark as completed: ");
                int taskIndex = scanner.nextInt();
                toDoList.markTaskAsCompleted(taskIndex);
            } else if (choice == 3) {
                toDoList.listTasks();
            } else if (choice == 4) {
                toDoList.listTasks(); // List tasks along with their indices
                System.out.print("Enter the index of the task to edit: ");
                int taskIndex = scanner.nextInt();
                System.out.print("Enter new description: ");
                scanner.nextLine();  // Consume the newline character
                String newDescription = scanner.nextLine();
                System.out.print("Enter new due date: ");
                String newDueDate = scanner.nextLine();
                toDoList.editTask(taskIndex, newDescription, newDueDate);
            } else if (choice == 5) {
                toDoList.listTasks(); // List tasks along with their indices
                System.out.print("Enter the index of the task to delete: ");
                int taskIndex = scanner.nextInt();
                toDoList.deleteTask(taskIndex);
            } else if (choice == 6) {
                System.out.println("Goodbye!");
                break;
            }
        }
    }
}
