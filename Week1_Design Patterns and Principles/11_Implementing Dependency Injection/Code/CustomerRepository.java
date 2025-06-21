public interface CustomerRepository {
    void addCustomer(int id, String name);
    String findCustomerById(int id);
}
