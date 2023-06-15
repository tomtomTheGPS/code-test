package com.danskebank.codetest.Service;

import com.danskebank.codetest.Model.Customer.Customer;
import com.danskebank.codetest.Repository.Customer.CustomerRepository;

public class CustomerService {

    private CustomerRepository customerRepository;

    public void createNewCustomer(String name) {
        customerRepository.addCustomer(name);
    }

    public Customer getCustomer(long id) {
        return customerRepository.getCustomer(id);
    }

    public void deleteCustomer(long id) {
        customerRepository.deleteCustomer(id);
    }
}
