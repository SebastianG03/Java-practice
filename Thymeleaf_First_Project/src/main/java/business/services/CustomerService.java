package business.services;

import business.entities.Customer;
import business.entities.repositories.CustomerRepository;

import java.util.List;

public class CustomerService {

    public CustomerService() {
        super();
    }

    public List<Customer> findAll() {
        return CustomerRepository.getInstance().findAll();
    }

    public Customer findById(final Integer id) {
        return CustomerRepository.getInstance().findById(id);
    }
}
