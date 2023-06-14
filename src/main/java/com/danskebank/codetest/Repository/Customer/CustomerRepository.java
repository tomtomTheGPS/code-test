package com.danskebank.codetest.Repository.Customer;

import java.util.HashMap;
import java.util.Map;

import com.danskebank.codetest.Model.Customer.Customer;

public class CustomerRepository {

    private Map<Long, Customer> customers = new HashMap<>();

    public void addCustomer(Customer customer) {
        customers.put(customer.getID(), customer);
    }

    public Customer getCustomer(long id) {
        return customers.get(id);
    }

    public void deleteCustomer(long id) {
        customers.remove(id);
    }

}
