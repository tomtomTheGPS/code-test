package com.danskebank.codetest.Repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.Collections;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.danskebank.codetest.Model.Account.Account;
import com.danskebank.codetest.Model.Customer.Customer;
import com.danskebank.codetest.Repository.Account.AccountRepository;

@SpringBootTest
public class AccountRepositoryTest {

    private AccountRepository accountRepository = new AccountRepository();

    @Test
    void accountRepositoryTest() {
        Account testAccount = new Account(1, new Customer(1, "testOwner", Collections.emptyList()), 10000);

        accountRepository.addAccount(testAccount);

        assertEquals(testAccount, accountRepository.getAccount(testAccount.getID()));

        accountRepository.deleteAccount(testAccount.getID());

        assertNull(accountRepository.getAccount(testAccount.getID()));

    }

}
