package ru.geographer29.entities;

import ru.geographer29.enums.Currency;
import ru.geographer29.interfaces.Close;

import java.math.BigDecimal;

public class Deposit extends AbstractBankProduct implements Close {

    public Deposit(String name, Currency currency, BigDecimal balance) {
        super(name, currency, balance);
    }

    @Override
    public void close() {
        balance = BigDecimal.ZERO;
    }

}