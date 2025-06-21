import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {

            System.out.print("Enter payment amount (₹): ");
            double amount = sc.nextDouble();

            System.out.println("Choose Payment Gateway: 1. PayPal  2. Stripe");
            int choice = sc.nextInt();

            PaymentProcessor processor;

            processor = switch (choice) {
                case 1 -> new PaypalAdapter(new PaypalGateway());
                case 2 -> new StripeAdapter(new StripeGateway());
                default -> null;
            };

            if (processor == null) {
                System.out.println("Invalid choice!");
                return;
            }

            processor.processPayment(amount);
        }
    }
}
