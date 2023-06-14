package com.danskebank.codetest.Model.Transaction;

import com.danskebank.codetest.Model.Account.Account;
import com.danskebank.codetest.Model.Enums.TransactionType;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Transaction {
    private long ID;
    private Account account;
    private TransactionType type;
    private long amount;
}
