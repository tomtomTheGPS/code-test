package com.danskebank.codetest.Repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.danskebank.codetest.Repository.Customer.CustomerRepository;

@SpringBootTest
public class CustomerRepositoryTest {

    private CustomerRepository customerRepository = new CustomerRepository();

    @Test
    void customerRepositoryTest() {
        customerRepository.addCustomer("testCustomer");
        long customerId = customerRepository.findCustomerID("testCustomer");

        assertEquals("testCustomer", customerRepository.getCustomer(customerId).getName());

        customerRepository.deleteCustomer(customerId);

        assertNull(customerRepository.getCustomer(customerId));

    }

}
