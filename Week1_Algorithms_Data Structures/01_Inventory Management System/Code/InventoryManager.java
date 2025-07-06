import java.util.HashMap;

public class InventoryManager {
    HashMap<Integer, Product> inventory = new HashMap<>();

    // Add product
    public void addProduct(Product p) {
        if (!inventory.containsKey(p.productId)) {
            inventory.put(p.productId, p);
            System.out.println("Product added: " + p);
        } else {
            System.out.println("Product ID already exists.");
        }
    }

    // Update product
    public void updateProduct(int productId, int quantity, double price) {
        if (inventory.containsKey(productId)) {
            Product p = inventory.get(productId);
            p.quantity = quantity;
            p.price = price;
            System.out.println("Product updated: " + p);
        } else {
            System.out.println("Product not found.");
        }
    }

    // Delete product
    public void deleteProduct(int productId) {
        if (inventory.containsKey(productId)) {
            Product removed = inventory.remove(productId);
            System.out.println("Product deleted: " + removed);
        } else {
            System.out.println("Product not found.");
        }
    }

    // Display inventory
    public void displayInventory() {
        if (inventory.isEmpty()) {
            System.out.println("Inventory is empty.");
        } else {
            for (Product p : inventory.values()) {
                System.out.println(p);
            }
        }
    }
}
