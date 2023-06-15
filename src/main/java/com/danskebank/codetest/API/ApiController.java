package com.danskebank.codetest.API;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.danskebank.codetest.Model.Enums.TransactionType;
import com.danskebank.codetest.Model.Transaction.Transaction;
import com.danskebank.codetest.Service.AccountService;
import com.danskebank.codetest.Service.CustomerService;
import com.danskebank.codetest.Service.TransactionService;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RequestMapping("/")
@RequiredArgsConstructor
@RestController
public class ApiController {
    private AccountService accountService;
    private CustomerService customerService;
    private TransactionService transactionService;

    @PostMapping("/customers")
    public ResponseEntity<String> createNewCustomer(@RequestBody String name) {
        customerService.createNewCustomer(name);
        return ResponseEntity.ok("Customer created successfully.");
    }

    @PostMapping("/customers/{customerID}/accounts")
    public ResponseEntity<String> createNewAccount(@PathVariable long customerID) {
        accountService.createNewAccount(customerID);
        return ResponseEntity.ok("Account created successfully.");
    }

    @GetMapping("/customers/{customerID}/accounts/{accountID}")
    public ResponseEntity<String> getAccountBalance(@PathVariable long customerID, @PathVariable long accountID) {
        long balance = accountService.getAccountBalance(customerID, accountID);
        return ResponseEntity.ok("Your current balance is: " + balance);
    }

    @PostMapping("/customers/{customerID}/accounts/{accountID}")
    public ResponseEntity<String> updateAccountBalance(
            @PathVariable long customerID,
            @PathVariable long accountID,
            @RequestParam TransactionType transactionType,
            @RequestParam long amount) {

        accountService.updateAccountBalance(customerID, accountID, transactionType, amount);

        return ResponseEntity.ok("Balance updated.");

    }

    @GetMapping("/customers/{customerID}/accounts/{accountID}/transactions")
    public ResponseEntity<List<Transaction>> getLatestTransactions(@PathVariable long accountID) {
        return ResponseEntity.ok(transactionService.getLatestTransactions(accountID));
    }

}
