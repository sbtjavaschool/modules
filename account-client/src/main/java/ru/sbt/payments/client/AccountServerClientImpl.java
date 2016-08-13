package ru.sbt.payments.client;

import ru.sbt.payments.account.Account;

public class AccountServerClientImpl implements AccountServerClient {
    @Override
    public void withdraw(String clientId, int amount) {

    }

    @Override
    public void deposit(String clientId, int amount) {

    }

    @Override
    public Account getAccount(String clientId) {
        return null;
    }
}
