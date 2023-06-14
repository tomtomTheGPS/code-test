package com.danskebank.codetest.Repository.Transaction;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.danskebank.codetest.Model.Transaction.Transaction;

public class TransactionRepository {

    private Map<Long, Transaction> transactions = new HashMap<Long, Transaction>();

    public void addTransaction(Transaction transaction) {
        transactions.put(transaction.getID(), transaction);
    }

    public Transaction getTransaction(long id) {
        return transactions.get(id);
    }

    public List<Transaction> getAllTransactions() {
        return new ArrayList<>(transactions.values());
    }

}
