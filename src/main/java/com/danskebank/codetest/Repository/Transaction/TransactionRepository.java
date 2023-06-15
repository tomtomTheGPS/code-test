package com.danskebank.codetest.Repository.Transaction;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.danskebank.codetest.Model.Enums.TransactionType;
import com.danskebank.codetest.Model.Transaction.Transaction;
import com.danskebank.codetest.Repository.BaseRepository;

public class TransactionRepository {

    private Map<Long, Map<Long, Transaction>> transactions = new HashMap<>();
    private BaseRepository baseRepository;

    public Transaction getTransaction(long accountId, long id) {
        try {
            return transactions.get(accountId).get(id);
        } catch (NullPointerException e) {
            return null;
        }
    }

    public void addTransaction(long accountId, TransactionType transactionType, long amount) {
        Map<Long, Transaction> accountTransactions = new HashMap<>();

        long transactionId = baseRepository.generateID();
        Transaction transaction = new Transaction(transactionId, accountId, transactionType, amount);

        accountTransactions.put(transactionId, transaction);
        transactions.put(accountId, accountTransactions);
    }

    public List<Transaction> getLatestTransactions(long accountId) {
        int transactionLimit = 10;
        Map<Long, Transaction> accountTransactions = getAccountTransactions(accountId);
        return new ArrayList<>(accountTransactions.values()).stream().limit(transactionLimit)
                .collect(Collectors.toList());
    }

    private Map<Long, Transaction> getAccountTransactions(long accountId) {
        Map<Long, Transaction> accountTransactions = new HashMap<>();
        try {
            accountTransactions = transactions.get(accountId);
        } catch (NullPointerException e) {

        }
        return accountTransactions;
    }
}
