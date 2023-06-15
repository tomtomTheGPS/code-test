// package com.danskebank.codetest.Repository;

// import static org.junit.jupiter.api.Assertions.assertEquals;
// import static org.junit.jupiter.api.Assertions.assertNull;

// import java.util.Collections;

// import org.junit.jupiter.api.Test;
// import org.springframework.boot.test.context.SpringBootTest;

// import com.danskebank.codetest.Model.Account.Account;
// import com.danskebank.codetest.Model.Customer.Customer;
// import com.danskebank.codetest.Repository.Account.AccountRepository;

// @SpringBootTest
// public class AccountRepositoryTest {

// private AccountRepository accountRepository = new AccountRepository();

// @Test
// void accountRepositoryTest() {
// accountRepository.createNewAccount(1);

// assertEquals(testAccount, accountRepository.getAccount(testAccount.getID()));

// accountRepository.deleteAllAccounts(1);

// assertNull(accountRepository.getAccount(testAccount.getID()));

// }

// }
