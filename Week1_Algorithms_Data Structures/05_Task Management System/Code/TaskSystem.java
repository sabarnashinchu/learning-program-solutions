import java.util.Scanner;

class Task {
    int taskId;
    String taskName;
    String status;
    Task next;

    Task(int id, String name, String status) {
        this.taskId = id;
        this.taskName = name;
        this.status = status;
        this.next = null;
    }
}

class TaskManager {
    Task head = null;

    // Add task at the end
    public void addTask(int id, String name, String status) {
        Task newTask = new Task(id, name, status);
        if (head == null) {
            head = newTask;
        } else {
            Task current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newTask;
        }
        System.out.println("Task Added!");
    }

    // Search task by ID
    public void searchTask(int id) {
        Task current = head;
        while (current != null) {
            if (current.taskId == id) {
                System.out.println(" Task Found -> ID: " + current.taskId + ", Name: " + current.taskName + ", Status: " + current.status);
                return;
            }
            current = current.next;
        }
        System.out.println("Task with ID " + id + " not found.");
    }

    // Traverse and display all tasks
    public void displayTasks() {
        if (head == null) {
            System.out.println("No tasks to display.");
            return;
        }
        System.out.println("Task List:");
        Task current = head;
        while (current != null) {
            System.out.println("ID: " + current.taskId + ", Name: " + current.taskName + ", Status: " + current.status);
            current = current.next;
        }
    }

    // Delete task by ID
    public void deleteTask(int id) {
        if (head == null) {
            System.out.println("No task to delete.");
            return;
        }

        if (head.taskId == id) {
            head = head.next;
            System.out.println("Task with ID " + id + " deleted.");
            return;
        }

        Task current = head;
        while (current.next != null && current.next.taskId != id) {
            current = current.next;
        }

        if (current.next == null) {
            System.out.println("Task with ID " + id + " not found.");
        } else {
            current.next = current.next.next;
            System.out.println("Task with ID " + id + " deleted.");
        }
    }
}

public class TaskSystem {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            TaskManager manager = new TaskManager();
            int choice;

            do {
                System.out.println("\n--- Task Management System ---");
                System.out.println("1. Add Task");
                System.out.println("2. Search Task");
                System.out.println("3. Display Tasks");
                System.out.println("4. Delete Task");
                System.out.println("5. Exit");
                System.out.print("Enter your choice: ");
                choice = sc.nextInt();
                sc.nextLine(); // consume newline

                switch (choice) {
                    case 1 -> {
                        System.out.print("Enter Task ID: ");
                        int id = sc.nextInt();
                        sc.nextLine();
                        System.out.print("Enter Task Name: ");
                        String name = sc.nextLine();
                        System.out.print("Enter Task Status: ");
                        String status = sc.nextLine();
                        manager.addTask(id, name, status);
                    }
                    case 2 -> {
                        System.out.print("Enter Task ID to search: ");
                        int searchId = sc.nextInt();
                        manager.searchTask(searchId);
                    }
                    case 3 -> manager.displayTasks();
                    case 4 -> {
                        System.out.print("Enter Task ID to delete: ");
                        int deleteId = sc.nextInt();
                        manager.deleteTask(deleteId);
                    }
                    case 5 -> System.out.println("Exiting...");
                    default -> System.out.println("Invalid choice. Try again.");
                }

            } while (choice != 5);
        }
    }
}
