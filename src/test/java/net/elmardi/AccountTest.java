package net.elmardi;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class AccountTest {
    @Test
    void shouldPrintExpectedStatement() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        Account account = new Account();
        account.deposit(1000, LocalDate.parse("10/01/2012", formatter));
        account.deposit(2000, LocalDate.parse("13/01/2012", formatter));
        account.withdraw(500, LocalDate.parse("14/01/2012", formatter));

        account.printStatement();

        String expected = """
        DATE       || AMOUNT || BALANCE
        14/01/2012 || -500   || 2500
        13/01/2012 || 2000   || 3000
        10/01/2012 || 1000   || 1000
        """;

        String actual = outContent.toString().replaceAll("\\s+", "");
        String expectedClean = expected.replaceAll("\\s+", "");

        assertTrue(actual.contains(expectedClean));
    }


}
