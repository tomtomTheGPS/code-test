package com.danskebank.codetest.Repository.Account;

import java.util.HashMap;
import java.util.Map;

import com.danskebank.codetest.Model.Account.Account;
import com.danskebank.codetest.Model.Enums.TransactionType;
import com.danskebank.codetest.Repository.BaseRepository;

public class AccountRepository {

    private Map<Long, Map<Long, Account>> accounts = new HashMap<>();
    private BaseRepository baseRepository;

    public void createNewAccount(long customerId) {
        long accountId = baseRepository.generateID();
        Account account = new Account(accountId, customerId, 0);

        Map<Long, Account> customerAccounts = getCustomerAccounts(customerId);
        customerAccounts.put(account.getID(), account);
        accounts.put(customerId, customerAccounts);
    }

    public void createNewAccount(long customerId, long initialBalance) {
        long accountId = baseRepository.generateID();
        Account account = new Account(accountId, customerId, initialBalance);

        Map<Long, Account> customerAccounts = getCustomerAccounts(customerId);
        customerAccounts.put(account.getID(), account);
        accounts.put(customerId, customerAccounts);
    }

    public Account getAccount(long customerId, long accountId) {
        Map<Long, Account> customerAccounts = getCustomerAccounts(customerId);
        return customerAccounts.get(accountId);
    }

    public void updateAccount(long customerId, Account account) {
        Map<Long, Account> customerAccounts = getCustomerAccounts(customerId);
        customerAccounts.put(account.getID(), account);
        accounts.put(customerId, customerAccounts);
    }

    public void deleteAllAccounts(long customerId) {
        accounts.remove(customerId);
    }

    public void deleteAccount(long customerId, long accountId) {
        Map<Long, Account> customerAccounts = getCustomerAccounts(customerId);
        customerAccounts.remove(accountId);
        accounts.put(customerId, customerAccounts);
    }

    public void updateAccountBalance(long customerId, long accountId, TransactionType transactionType, long amount) {
        Account account = getAccount(customerId, accountId);
        long accountBalance = account.getBalance();
        long newAccountBalance = transactionType == TransactionType.DEPOSIT
                ? accountBalance + amount
                : accountBalance - amount;
        account.setBalance(newAccountBalance);

        updateAccount(customerId, account);
    }

    private Map<Long, Account> getCustomerAccounts(long customerId) {
        Map<Long, Account> customerAccounts = new HashMap<>();
        try {
            customerAccounts = accounts.get(customerId);
        } catch (NullPointerException e) {
        }
        return customerAccounts;
    }

}
