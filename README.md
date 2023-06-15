These are the thoughts upon which this project has been build. It is not completed, and I can't guarantee that it works. Consider it a showcase of a proposed project-structure more than a working application.

## Scope:

-   Micro Service architecture exposed with REST API
-   Test driven approach

### Features:

-   Create account
-   Deposit money
-   Withdraw money
-   Get balance
-   List last 10 transactions

## Possible endpoints for a finished application

-   Base URL ("/")
    -   GET: List of endpoints
-   Customers ("/costumers")
    -   GET: List of costumers
    -   POST: New costumer
-   Customer ("/costumers/{costumer_ID}")
    -   GET: List of costumer info
    -   DELETE: Delete costumer
-   Accounts ("/costumers/{costumer_ID}/accounts")
    -   GET: List of accounts
    -   POST: New account
-   Account ("/customers/{customer_ID}/accounts/{account_ID}")
    -   GET: Get balance
    -   POST: Deposit money
    -   POST: Withdraw money
    -   DELETE: Delete account
-   Transactions ("/customers/{customer_ID}/accounts/{account_ID}/transactions")
    -   GET: List transactions

## Project structure

-   Model
    -   Customer
        -   ID
        -   Name
        -   Accounts
    -   Account
        -   ID
        -   Owner
        -   Balance
    -   Transaction
        -   ID
        -   Account
        -   Type
        -   Amount
-   Repository
    -   Customer
        -   Get customer
        -   Get all customers
        -   Create new customer
        -   Delete Customer
    -   Account
        -   Get account
        -   Get all accounts
        -   Create new account
        -   Delete account
    -   Transaction
        -   Get transaction
        -   Get all transactions
        -   Create transaction
-   Service
    -   Customer service
        -   Create customer
        -   Delete customer
        -   Get customer info
    -   Account service
        -   Create account
        -   Delete account
        -   Update balance
        -   Get balance
    -   Transaction service
        -   Get transaction list
-   API
    -   Controller
        -   {Implementation of all Endpoints}
-   App
    -   BaseApp
