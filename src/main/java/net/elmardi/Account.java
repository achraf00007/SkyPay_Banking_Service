package net.elmardi;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Account implements AccountService{
    private List<Transaction> transactions = new ArrayList<>();
    private StatementService printer = new StatementService();
    private int balance = 0;

    @Override
    public void deposit(int amount, LocalDate date) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Amount must be greater than 0");
        }
        balance += amount;
        transactions.add(new Transaction(date, amount, balance));
    }

    @Override
    public void withdraw(int amount, LocalDate date) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Amount must be greater than 0");
        }
        if (amount > balance) {
            throw new IllegalArgumentException("Amount must be less than balance");
        }
        balance -= amount;
        transactions.add(new Transaction(date, -amount, balance));
    }

    @Override
    public void printStatement() {
        printer.print(transactions);
    }
}
