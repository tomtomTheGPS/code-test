package com.danskebank.codetest.Repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.Collections;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.danskebank.codetest.Model.Customer.Customer;
import com.danskebank.codetest.Repository.Customer.CustomerRepository;

@SpringBootTest
public class CustomerRepositoryTest {

    private CustomerRepository customerRepository = new CustomerRepository();

    @Test
    void customerRepositoryTest() {
        Customer testCustomer = new Customer(1, "testCustomer", Collections.emptyList());

        customerRepository.addCustomer(testCustomer);

        assertEquals(testCustomer, customerRepository.getCustomer(testCustomer.getID()));

        customerRepository.deleteCustomer(testCustomer.getID());

        assertNull(customerRepository.getCustomer(testCustomer.getID()));

    }

}
