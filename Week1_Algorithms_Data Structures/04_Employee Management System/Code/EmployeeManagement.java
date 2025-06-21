import java.util.Scanner;

public class EmployeeManagement {
    static Employee[] employees = new Employee[100]; 
    static int count = 0;
    static void addEmployee(Scanner sc) {
        System.out.print("Enter Employee ID: ");
        int id = sc.nextInt();
        sc.nextLine(); // consume newline

        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Position: ");
        String position = sc.nextLine();

        System.out.print("Enter Salary: ");
        double salary = sc.nextDouble();

        employees[count++] = new Employee(id, name, position, salary);
        System.out.println("Employee Added Successfully!\n");
    }

    // Search employee by ID
    static void searchEmployee(Scanner sc) {
        System.out.print("Enter Employee ID to search: ");
        int id = sc.nextInt();
        boolean found = false;

        for (int i = 0; i < count; i++) {
            if (employees[i].employeeId == id) {
                employees[i].display();
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Employee Not Found!\n");
        }
    }

    // Traverse all employees
    static void displayAllEmployees() {
        System.out.println("All Employee Records:");
        for (int i = 0; i < count; i++) {
            employees[i].display();
        }
        System.out.println();
    }

    // Delete employee by ID
    static void deleteEmployee(Scanner sc) {
        System.out.print("Enter Employee ID to delete: ");
        int id = sc.nextInt();
        boolean found = false;

        for (int i = 0; i < count; i++) {
            if (employees[i].employeeId == id) {
                // Shift elements left
                for (int j = i; j < count - 1; j++) {
                    employees[j] = employees[j + 1];
                }
                employees[count - 1] = null;
                count--;
                found = true;
                System.out.println("Employee Deleted Successfully!\n");
                break;
            }
        }

        if (!found) {
            System.out.println("Employee Not Found!\n");
        }
    }

    // Main Menu
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int choice;

            do {
                System.out.println("----- Employee Management System -----");
                System.out.println("1. Add Employee");
                System.out.println("2. Search Employee");
                System.out.println("3. Display All Employees");
                System.out.println("4. Delete Employee");
                System.out.println("5. Exit");
                System.out.print("Enter your choice: ");
                choice = sc.nextInt();

                switch (choice) {
                    case 1 -> addEmployee(sc);
                    case 2 -> searchEmployee(sc);
                    case 3 -> displayAllEmployees();
                    case 4 -> deleteEmployee(sc);
                    case 5 -> System.out.println("Exiting...");
                    default -> System.out.println("Invalid Choice!\n");
                }

            } while (choice != 5);
        }
    }
}
