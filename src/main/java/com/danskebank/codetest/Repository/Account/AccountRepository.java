package com.danskebank.codetest.Repository.Account;

import java.util.HashMap;
import java.util.Map;

import com.danskebank.codetest.Model.Account.Account;

public class AccountRepository {

    private Map<Long, Account> accounts = new HashMap<Long, Account>();

    public void addAccount(Account account) {
        accounts.put(account.getID(), account);
    }

    public Account getAccount(long id) {
        return accounts.get(id);
    }

    public void deleteAccount(long id) {
        accounts.remove(id);
    }

}
