package ru.sbt.payments.client;

import ru.sbt.payments.account.Account;

import java.util.List;

public interface AccountServerClient {
    void withdraw(String clientId, int amount);

    void deposit(String clientId, int amount);

    Account getAccount(String clientId);
}
