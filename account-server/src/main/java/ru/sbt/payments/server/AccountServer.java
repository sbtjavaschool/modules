package ru.sbt.payments.server;

import ru.sbt.payments.account.Account;

import java.util.HashMap;
import java.util.Map;

public class AccountServer {
    private final Map<String, Integer> balanceByClientId = new HashMap<String, Integer>();

    public void withdraw(String clientId, int amount) {
        if (amount > 100) {
            throw new IllegalArgumentException("Client " + clientId + " doesn't have " + amount + "$");
        }

        deposit(clientId, -amount);
    }

    public void deposit(String clientId, int amount) {
        balanceByClientId.compute(clientId,
                (ignore, oldBalance) -> (oldBalance == null ? 0 : oldBalance) + amount);
    }

    public double balance(String clientId) {
        return balanceByClientId.getOrDefault(clientId, 0);
    }

    public Account getAccount(String clientId) {
        return null;
    }
}
