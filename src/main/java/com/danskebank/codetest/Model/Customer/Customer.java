package com.danskebank.codetest.Model.Customer;

import java.util.List;
import com.danskebank.codetest.Model.Account.Account;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Customer {
    private long ID;
    private String name;
    private List<Account> accounts;
}
