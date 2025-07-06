// File: Main.java

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Enter the first log message: ");
            String msg1 = sc.nextLine();

            Logger logger1 = Logger.getInstance();
            logger1.log(msg1);

            System.out.print("Enter the second log message: ");
            String msg2 = sc.nextLine();

            Logger logger2 = Logger.getInstance();
            logger2.log(msg2);
            if (logger1 == logger2) {
                System.out.println("Both logger instances are the same. Singleton works!");
            } else {
                System.out.println("Logger instances are different. Singleton failed.");
            }

        }

    }
}
