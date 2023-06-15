package com.danskebank.codetest.Service;

import com.danskebank.codetest.Model.Account.Account;
import com.danskebank.codetest.Model.Enums.TransactionType;
import com.danskebank.codetest.Repository.Account.AccountRepository;
import com.danskebank.codetest.Repository.Transaction.TransactionRepository;

public class AccountService {

    private AccountRepository accountRepository;
    private TransactionRepository transactionRepository;

    public void createNewAccount(long ownerId) {
        accountRepository.createNewAccount(ownerId);
    }

    public void createNewAccount(long ownerId, long initialBalance) {
        accountRepository.createNewAccount(ownerId, initialBalance);
    }

    public void deleteAccount(long customerId, long accountId) {
        accountRepository.deleteAccount(customerId, accountId);
    }

    public long getAccountBalance(long customerId, long accountId) {
        Account account = accountRepository.getAccount(customerId, accountId);
        long accountBalance = account.getBalance();

        return accountBalance;
    }

    public void updateAccountBalance(long customerId, long accountId, TransactionType transactionType, long amount) {
        transactionRepository.addTransaction(accountId, transactionType, amount);

        try {
            accountRepository.updateAccountBalance(customerId, accountId, transactionType, amount);
        } catch (Exception e) {
        }
    }

}
