import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        InventoryManager manager = new InventoryManager();
        int choice;

        try (Scanner sc = new Scanner(System.in)) {
            do {
                System.out.println("\n1. Add Product");
                System.out.println("2. Update Product");
                System.out.println("3. Delete Product");
                System.out.println("4. Display Inventory");
                System.out.println("5. Exit");
                System.out.print("Enter your choice: ");
                choice = sc.nextInt();

                switch (choice) {
                    case 1 -> {
                        System.out.print("Enter Product ID: ");
                        int id = sc.nextInt();
                        sc.nextLine();  
                        System.out.print("Enter Product Name: ");
                        String name = sc.nextLine();
                        System.out.print("Enter Quantity: ");
                        int qty = sc.nextInt();
                        System.out.print("Enter Price: ");
                        double price = sc.nextDouble();
                        Product p = new Product(id, name, qty, price);
                        manager.addProduct(p);
                    }
                    case 2 -> {
                        System.out.print("Enter Product ID to update: ");
                        int uid = sc.nextInt();
                        System.out.print("Enter New Quantity: ");
                        int newQty = sc.nextInt();
                        System.out.print("Enter New Price: ");
                        double newPrice = sc.nextDouble();
                        manager.updateProduct(uid, newQty, newPrice);
                    }
                    case 3 -> {
                        System.out.print("Enter Product ID to delete: ");
                        int did = sc.nextInt();
                        manager.deleteProduct(did);
                    }
                    case 4 -> manager.displayInventory();
                    case 5 -> System.out.println("Exiting...");
                    default -> System.out.println("Invalid choice!");
                }
            } while (choice != 5);
        }
    }
}
