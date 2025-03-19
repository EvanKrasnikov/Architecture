package ru.geographer29.entities;

import ru.geographer29.enums.Currency;

import java.math.BigDecimal;

public class CurrencyDebitCard extends AbstractCard {

    public CurrencyDebitCard(String name, Currency currency, BigDecimal balance) {
        super(name, currency, balance);
    }

}