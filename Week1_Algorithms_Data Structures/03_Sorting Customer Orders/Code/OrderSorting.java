import java.util.Scanner;

class Order {
    int orderId;
    String customerName;
    double totalPrice;

    Order(int orderId, String customerName, double totalPrice) {
        this.orderId = orderId;
        this.customerName = customerName;
        this.totalPrice = totalPrice;
    }

    void display() {
        System.out.println(orderId + " - " + customerName + " - " + totalPrice);
    }
}

public class OrderSorting {

    // Bubble Sort
    public static void bubbleSort(Order[] orders) {
        int n = orders.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if (orders[j].totalPrice > orders[j + 1].totalPrice) {
                    // swap
                    Order temp = orders[j];
                    orders[j] = orders[j + 1];
                    orders[j + 1] = temp;
                }
            }
        }
    }

    // Quick Sort
    public static void quickSort(Order[] orders, int low, int high) {
        if (low < high) {
            int pi = partition(orders, low, high);
            quickSort(orders, low, pi - 1);
            quickSort(orders, pi + 1, high);
        }
    }

    private static int partition(Order[] orders, int low, int high) {
        double pivot = orders[high].totalPrice;
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (orders[j].totalPrice <= pivot) {
                i++;
                Order temp = orders[i];
                orders[i] = orders[j];
                orders[j] = temp;
            }
        }
        Order temp = orders[i + 1];
        orders[i + 1] = orders[high];
        orders[high] = temp;
        return i + 1;
    }

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {

            System.out.print("Enter number of orders: ");
            int n = sc.nextInt();
            sc.nextLine();

            Order[] orders = new Order[n];

            for (int i = 0; i < n; i++) {
                System.out.print("Enter Order ID: ");
                int id = sc.nextInt();
                sc.nextLine();
                System.out.print("Enter Customer Name: ");
                String name = sc.nextLine();
                System.out.print("Enter Total Price: ");
                double price = sc.nextDouble();
                orders[i] = new Order(id, name, price);
            }

            System.out.println("\nSorted by Bubble Sort (Ascending by Total Price):");
            bubbleSort(orders);
            for (Order o : orders) {
                o.display();
            }

            Order[] orders2 = new Order[n];
            for (int i = 0; i < n; i++) {
                orders2[i] = new Order(orders[i].orderId, orders[i].customerName, orders[i].totalPrice);
            }

            System.out.println("\nSorted by Quick Sort (Ascending by Total Price):");
            quickSort(orders2, 0, n - 1);
            for (Order o : orders2) {
                o.display();
            }
        }
    }
}
