package com.danskebank.codetest.Service;

import java.util.List;

import com.danskebank.codetest.Model.Transaction.Transaction;
import com.danskebank.codetest.Repository.Transaction.TransactionRepository;

public class TransactionService {

    private TransactionRepository transactionRepository;

    public List<Transaction> getLatestTransactions(long accountId) {
        return transactionRepository.getLatestTransactions(accountId);
    }
}
