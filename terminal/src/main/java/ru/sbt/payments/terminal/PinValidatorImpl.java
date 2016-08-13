package ru.sbt.payments.terminal;

public class PinValidatorImpl implements PinValidator {
    @Override
    public void validate(int pin) {
        if (pin != 78) throw new IllegalArgumentException();
    }
}
