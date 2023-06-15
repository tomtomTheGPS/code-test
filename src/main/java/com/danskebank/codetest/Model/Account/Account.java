package com.danskebank.codetest.Model.Account;

import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Account {
    private long ID;
    private long ownerId;
    private long balance;
}
