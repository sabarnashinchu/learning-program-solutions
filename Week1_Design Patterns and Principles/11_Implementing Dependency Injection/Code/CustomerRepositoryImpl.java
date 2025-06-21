import java.util.HashMap;
import java.util.Map;

public class CustomerRepositoryImpl implements CustomerRepository {
    private final Map<Integer, String> customers = new HashMap<>();

    @Override
    public void addCustomer(int id, String name) {
        customers.put(id, name);
    }

    @Override
    public String findCustomerById(int id) {
        if (customers.containsKey(id)) {
            return "Customer Name: " + customers.get(id);
        } else {
            return "Customer not found!";
        }
    }
}
