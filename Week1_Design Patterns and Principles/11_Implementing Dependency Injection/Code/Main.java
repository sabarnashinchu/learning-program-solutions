import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {

            CustomerRepository repository = new CustomerRepositoryImpl();
            CustomerService service = new CustomerService(repository);

            System.out.print("How many customers do you want to enter? ");
            int count = scanner.nextInt();
            scanner.nextLine(); 

            for (int i = 0; i < count; i++) {
                System.out.print("Enter Customer ID: ");
                int id = scanner.nextInt();
                scanner.nextLine(); 

                System.out.print("Enter Customer Name: ");
                String name = scanner.nextLine();

                service.addCustomer(id, name);
            }

            System.out.print("Enter ID to search: ");
            int searchId = scanner.nextInt();
            service.searchCustomer(searchId);
        }
    }
}
