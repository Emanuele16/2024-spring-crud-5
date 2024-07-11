package org.spring_crud5.spring_crud5.serv;

import java.util.List;

import org.spring_crud5.spring_crud5.pojo.Customer;
import org.spring_crud5.spring_crud5.repo.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class CustomerService {

    @Autowired
    private CustomerRepo customerRepository;

    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    public Customer getCustomerById(int id) {
        return customerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Customer not found with id " + id));
    }

    public void saveCustomer(Customer customer) {
        customerRepository.save(customer);
    }

    public void deleteCustomer(int id) {
        customerRepository.deleteById(id);
    }
}
