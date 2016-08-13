package ru.sbt.payments.terminal;

import ru.sbt.payments.account.Transaction;
import ru.sbt.payments.client.AccountServerClient;

import java.util.List;

public class TerminalImpl implements Terminal {
    private final PinValidator pinValidator;
    private final AccountServerClient accountServerClient;
    private String clientId;

    public TerminalImpl(PinValidator pinValidator, AccountServerClient accountServerClient) {
        this.pinValidator = pinValidator;
        this.accountServerClient = accountServerClient;
    }

    public void enterCard(String clientId) {
        this.clientId = clientId;
    }

    public void validatePin(int pin) {
        pinValidator.validate(pin);
    }

    public void withdraw(int amount) {
        accountServerClient.withdraw(clientId, amount);
    }

    public void deposit(int amount) {
        accountServerClient.deposit(clientId, amount);
    }

    public double balance() {
        return accountServerClient.getAccount(clientId).getBalance();
    }

    @Override
    public List<Transaction> lastTransaction() {
        return accountServerClient.getAccount(clientId).getLastTransactions();
    }
}
