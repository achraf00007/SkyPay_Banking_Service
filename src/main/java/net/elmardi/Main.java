package net.elmardi;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Main {
    public static void main(String[] args) {
        Account account = new Account();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        account.deposit(1000, LocalDate.parse("10/01/2012", formatter));
        account.deposit(2000, LocalDate.parse("13/01/2012", formatter));
        account.withdraw(500, LocalDate.parse("14/01/2012", formatter));

        account.printStatement();
    }
}