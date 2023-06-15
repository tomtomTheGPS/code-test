package com.danskebank.codetest.Repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.danskebank.codetest.Model.Account.Account;
import com.danskebank.codetest.Model.Customer.Customer;
import com.danskebank.codetest.Model.Enums.TransactionType;
import com.danskebank.codetest.Model.Transaction.Transaction;
import com.danskebank.codetest.Repository.Transaction.TransactionRepository;

@SpringBootTest
public class TransactionRepositoryTest {

        private TransactionRepository transactionRepository = new TransactionRepository();

        @Test
        void createAndGetNewTransactionTest() {

                Transaction testTransaction = new Transaction(
                                1,
                                new Account(1, new Customer(1, "testOwner", Collections.emptyList()), 10000),
                                TransactionType.DEPOSIT,
                                100);

                transactionRepository.addTransaction(testTransaction);

                assertEquals(testTransaction, transactionRepository.getTransaction(testTransaction.getID()));

        }

        @Test
        void getAllTransactionsTest() {

                Transaction testTransaction1 = new Transaction(
                                1,
                                new Account(1, new Customer(1, "testOwner", Collections.emptyList()), 10000),
                                TransactionType.DEPOSIT,
                                100);

                Transaction testTransaction2 = new Transaction(
                                2,
                                new Account(1, new Customer(1, "testOwner", Collections.emptyList()), 10000),
                                TransactionType.DEPOSIT,
                                200);

                Transaction testTransaction3 = new Transaction(
                                3,
                                new Account(1, new Customer(1, "testOwner", Collections.emptyList()), 10000),
                                TransactionType.WITHDRAW,
                                300);

                transactionRepository.addTransaction(testTransaction1);
                transactionRepository.addTransaction(testTransaction2);
                transactionRepository.addTransaction(testTransaction3);

                List<Transaction> expectedList = List.of(testTransaction1, testTransaction2, testTransaction3);
                List<Transaction> transactions = transactionRepository.getLatestTransactions();

                assertEquals(expectedList, transactions);

        }

}
