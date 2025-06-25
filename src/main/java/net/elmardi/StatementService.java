package net.elmardi;

import java.time.format.DateTimeFormatter;
import java.util.List;

public class StatementService {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public void print(List<Transaction> transactions) {
        System.out.println("\n-------------------------------------\n");
        System.out.println("DATE       || AMOUNT || BALANCE");
        transactions.stream()
                .sorted((a, b) -> b.getDate().compareTo(a.getDate()))
                .forEach(t -> System.out.printf("%s || %s   || %s%n",
                        t.getDate().format(formatter),
                        (t.getAmount() >= 0 ? t.getAmount() : "-" + Math.abs(t.getAmount())),
                        t.getBalance()));

        System.out.println("\n-------------------------------------\n");
    }
}
