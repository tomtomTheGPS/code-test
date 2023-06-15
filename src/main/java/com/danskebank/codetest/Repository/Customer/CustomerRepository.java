package com.danskebank.codetest.Repository.Customer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.danskebank.codetest.Model.Account.Account;
import com.danskebank.codetest.Model.Customer.Customer;
import com.danskebank.codetest.Repository.BaseRepository;

public class CustomerRepository {

    private Map<Long, Customer> customers = new HashMap<>();
    private BaseRepository baseRepository;

    public void addCustomer(String name) {
        List<Account> accounts = new ArrayList<>();
        long id = baseRepository.generateID();
        Customer customer = new Customer(id, name, accounts);
        customers.put(id, customer);
    }

    public Customer getCustomer(long id) {
        return customers.get(id);
    }

    public void deleteCustomer(long id) {
        customers.remove(id);
    }

}
