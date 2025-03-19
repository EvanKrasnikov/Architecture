package ru.geographer29.entities;

import ru.geographer29.enums.Currency;
import ru.geographer29.interfaces.BankProduct;

import java.math.BigDecimal;

public abstract class AbstractBankProduct implements BankProduct {

    protected String name;
    protected Currency currency;
    protected BigDecimal balance;

    public AbstractBankProduct(String name, Currency currency, BigDecimal balance) {
        this.name = name;
        this.currency = currency;
        this.balance = balance;
    }

    @Override
    public void replenishBalance(BigDecimal sum) {
        balance = balance.add(sum);
    }

    @Override
    public BigDecimal getBalance() {
        return balance;
    }

}