import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        PaymentContext context = new PaymentContext();

        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("Choose payment method:");
            System.out.println("1. Credit Card");
            System.out.println("2. PayPal");
            System.out.print("Enter choice (1 or 2): ");
            int choice = sc.nextInt();

            System.out.print("Enter amount to pay: ₹");
            double amount = sc.nextDouble();

            switch (choice) {
                case 1 -> context.setPaymentStrategy(new CreditCardPayment());
                case 2 -> context.setPaymentStrategy(new PayPalPayment());
                default -> {
                    System.out.println("Invalid choice.");
                    return;
                }
            }

            context.payAmount(amount);
        }
    }
}
