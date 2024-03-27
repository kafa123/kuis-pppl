package org.example;

// Class 1: BankAccount
public class BankAccount {
    private double balance;
    private String accountNumber;
    private static final double OVERDRAFT_FEE = 25.0;

    public BankAccount(String accountNumber, double initialBalance) {
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("Deposit amount cannot be negative.");
        }
        balance += amount;
    }

    public void withdraw(double amount) {
        if (amount > balance) {
            balance -= OVERDRAFT_FEE;
        } else {
            balance -= amount;
        }
    }

    public void transferFunds(BankAccount recipient, double amount) {
        if (amount > balance) {
            throw new IllegalArgumentException("Insufficient funds for transfer.");
        }
        withdraw(amount);
        recipient.deposit(amount);
    }
}

