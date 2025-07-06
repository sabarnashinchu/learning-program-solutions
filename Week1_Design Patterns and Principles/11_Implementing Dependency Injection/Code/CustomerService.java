public class CustomerService {
    private final CustomerRepository customerRepository;

    // Constructor injection
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public void addCustomer(int id, String name) {
        customerRepository.addCustomer(id, name);
    }

    public void searchCustomer(int id) {
        String result = customerRepository.findCustomerById(id);
        System.out.println(result);
    }
}
