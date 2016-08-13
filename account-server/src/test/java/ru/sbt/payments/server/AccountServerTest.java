package ru.sbt.payments.server;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class AccountServerTest {
    AccountServer accountServer = new AccountServer();

    @Test(expected = IllegalArgumentException.class)
    public void withdrawToMach() {
        accountServer.withdraw("some_id", 101);
    }

    @Test
    public void withdrawNormalAmount() {
        accountServer.withdraw("12", 99);
    }

    @Test
    public void testWithdraw() {
        doTransaction(-10, -10);
        doTransaction(-15, -25);
        doTransaction(-100, -125);
        doTransaction(50, -75);
        doTransaction(75, 0);
        doTransaction(1000, 1000);
    }

    private void doTransaction(int amount, double expected) {
        String client = "client";
        if (amount < 0) {
            accountServer.withdraw(client, -amount);
        } else {
            accountServer.deposit(client, amount);
        }

        assertEquals(expected, accountServer.balance(client), 0d);
    }

    @Test
    public void balanceOnNewClient() {
        double balance = accountServer.balance("new_client");
        assertEquals(0, balance, 0d);
    }
}