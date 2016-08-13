package ru.sbt.payments.terminal;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import ru.sbt.payments.account.Account;
import ru.sbt.payments.client.AccountServerClient;

import java.util.Collections;
import java.util.Date;

import static java.util.Collections.emptyList;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class TerminalImplTest {
    @Mock
    PinValidator pinValidator;
    @Mock
    AccountServerClient accountServerClient;
    Terminal terminal;

    @Before
    public void setUp() throws Exception {
        terminal = new TerminalImpl(pinValidator, accountServerClient);
    }

    @Test(expected = IllegalArgumentException.class)
    public void validateBadPin() {
        doThrow(IllegalArgumentException.class).when(pinValidator).validate(20);
        terminal.validatePin(20);
    }

    @Test
    public void validatePin() {
        terminal.validatePin(100);
        verify(pinValidator).validate(100);
    }

    @Test
    public void testBalance(){
        String clientId = "client_id";
        Account acc = new Account(clientId, 300, new Date(), emptyList());
        when(accountServerClient.getAccount(clientId)).thenReturn(acc);

        terminal.enterCard(clientId);
        assertEquals(300, terminal.balance(), 0);
    }

    @Test
    public void deposit() throws Exception {
        String clientId = "dd";
        terminal.enterCard(clientId);
        terminal.deposit(100);
        verify(accountServerClient).deposit(clientId, 100);
    }
}