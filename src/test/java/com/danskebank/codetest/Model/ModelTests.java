package com.danskebank.codetest.Model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.danskebank.codetest.Model.Account.Account;
import com.danskebank.codetest.Model.Customer.Customer;
import com.danskebank.codetest.Model.Enums.TransactionType;
import com.danskebank.codetest.Model.Transaction.Transaction;

@SpringBootTest
class ModelTests {

	@Test
	void initializeCustomer() {
		long id = 1;
		String name = "test";
		List<Account> accounts = Collections.emptyList();

		Customer testCustomer = new Customer(id, name, accounts);

		assertEquals(id, testCustomer.getID());
		assertEquals(name, testCustomer.getName());
	}

	@Test
	void initializeAccount() {
		long id = 1;
		long balance = 100000;

		Account testAccount = new Account(id, id, balance);

		assertEquals(id, testAccount.getID());
		assertEquals(id, testAccount.getOwnerId());
		assertEquals(balance, testAccount.getBalance());
	}

	@Test
	void initializeTransaction() {
		long id = 1;
		Account account = new Account(id, id, 10000);
		TransactionType type = TransactionType.DEPOSIT;
		long amount = 100;

		Transaction testTransaction = new Transaction(id, id, type, amount);

		assertEquals(id, testTransaction.getID());
		assertEquals(id, testTransaction.getAccountId());

		assertEquals(type, testTransaction.getType());
		assertEquals(amount, testTransaction.getAmount());

	}

}
