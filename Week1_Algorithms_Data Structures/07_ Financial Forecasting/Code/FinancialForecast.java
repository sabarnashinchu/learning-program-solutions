
import java.util.Scanner;

public class FinancialForecast {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {

            System.out.print("Enter the current value (₹): ");
            double currentValue = sc.nextDouble();

            System.out.print("Enter the annual growth rate (%): ");
            double growthRate = sc.nextDouble();

            System.out.print("Enter number of years to forecast: ");
            int years = sc.nextInt();

            // Using formula: A = P * (1 + r)^n
            double futureValue = currentValue * Math.pow(1 + growthRate / 100, years);

            System.out.printf("The forecasted value after %d years is ₹%.2f\n", years, futureValue);
        }
    }
}
