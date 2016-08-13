package ru.sbt.payments.account;

import java.util.Date;

public class Transaction {
    private final Date date;
    private final double money;
    private final String shop;

    public Transaction(Date date, double money, String shop) {
        this.date = date;
        this.money = money;
        this.shop = shop;
    }

    public Date getDate() {
        return date;
    }

    public double getMoney() {
        return money;
    }

    public String getShop() {
        return shop;
    }
}
