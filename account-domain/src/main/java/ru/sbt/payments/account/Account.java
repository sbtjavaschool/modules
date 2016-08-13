package ru.sbt.payments.account;

import java.util.Date;
import java.util.List;

public class Account {
    private final String clientId;
    private final double balance;
    private final Date openDate;
    private final List<Transaction> lastTransactions;

    public Account(String clientId, double balance, Date openDate, List<Transaction> lastTransactions) {
        this.clientId = clientId;
        this.balance = balance;
        this.openDate = openDate;
        this.lastTransactions = lastTransactions;
    }

    public String getClientId() {
        return clientId;
    }

    public double getBalance() {
        return balance;
    }

    public Date getOpenDate() {
        return openDate;
    }

    public List<Transaction> getLastTransactions() {
        return lastTransactions;
    }
}
