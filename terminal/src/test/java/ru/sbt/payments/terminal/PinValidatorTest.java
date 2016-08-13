package ru.sbt.payments.terminal;

import org.junit.Test;

import static org.junit.Assert.*;

public class PinValidatorTest {
    PinValidator pinValidator = new PinValidatorImpl();

    @Test
    public void testGoodPin()  {
        pinValidator.validate(78);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testBadPin()  {
        pinValidator.validate(50);
    }

}