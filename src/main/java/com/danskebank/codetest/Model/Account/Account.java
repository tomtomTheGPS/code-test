package com.danskebank.codetest.Model.Account;

import com.danskebank.codetest.Model.Customer.Customer;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Account {
    private long ID;
    private Customer owner;
    private long balance;
}
