package ru.sbt.payments.terminal;

import ru.sbt.payments.account.Transaction;

import java.util.List;

public interface Terminal {
    void validatePin(int pin);

    void withdraw(int amount);

    void deposit(int amount);

    double balance();

    List<Transaction> lastTransaction();
}
