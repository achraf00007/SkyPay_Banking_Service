package net.elmardi;

import java.time.LocalDate;

public class Transaction {
    private LocalDate date;
    private int amount;
    private int balance;

    public Transaction(LocalDate date, int amount, int balance) {
        this.balance = balance;
        this.amount = amount;
        this.date = date;
    }

    public LocalDate getDate() {
        return date;
    }

    public int getAmount() {
        return amount;
    }

    public int getBalance() {
        return balance;
    }
}
