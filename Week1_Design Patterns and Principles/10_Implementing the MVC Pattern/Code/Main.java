import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {

            // Input from user
            System.out.print("Enter Student Name: ");
            String name = scanner.nextLine();

            System.out.print("Enter Student ID: ");
            String id = scanner.nextLine();

            System.out.print("Enter Student Grade: ");
            String grade = scanner.nextLine();

            // Create Model
            Student student = new Student();
            student.setName(name);
            student.setId(id);
            student.setGrade(grade);

            // Create View
            StudentView view = new StudentView();

            // Create Controller
            StudentController controller = new StudentController(student, view);

            // Display initial details
            controller.updateView();

            // Update Section
            System.out.print("\nDo you want to update any details? (yes/no): ");
            String choice = scanner.nextLine();

            if(choice.equalsIgnoreCase("yes")) {
                System.out.println("\nWhat do you want to update?");
                System.out.println("1. Name");
                System.out.println("2. ID");
                System.out.println("3. Grade");
                System.out.println("4. All");
                System.out.print("Enter option (1-4): ");
                int option = scanner.nextInt();
                scanner.nextLine(); 

                if(option == 1 || option == 4) {
                    System.out.print("Enter new Name: ");
                    String newName = scanner.nextLine();
                    controller.setStudentName(newName);
                }

                if(option == 2 || option == 4) {
                    System.out.print("Enter new ID: ");
                    String newId = scanner.nextLine();
                    controller.setStudentId(newId);
                }

                if(option == 3 || option == 4) {
                    System.out.print("Enter new Grade: ");
                    String newGrade = scanner.nextLine();
                    controller.setStudentGrade(newGrade);
                }
            }

            // Display updated details
            controller.updateView();
        }
    }
}
