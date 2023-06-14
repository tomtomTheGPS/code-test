package com.danskebank.codetest.Model.Transaction;

import com.danskebank.codetest.Model.Account.Account;
import com.danskebank.codetest.Model.Enums.TransactionType;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Transaction {
    private long ID;
    private Account account;
    private TransactionType type;
    private long amount;
}
