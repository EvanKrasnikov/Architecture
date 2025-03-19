package ru.geographer29.entities;

import ru.geographer29.enums.Currency;

import java.math.BigDecimal;

public class DebitCard extends AbstractCard {

    public DebitCard(String name, Currency currency, BigDecimal balance) {
        super(name, currency, balance);
    }

}