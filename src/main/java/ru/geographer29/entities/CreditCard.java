package ru.geographer29.entities;

import ru.geographer29.enums.Currency;
import ru.geographer29.interfaces.Debt;

import java.math.BigDecimal;

import static java.math.RoundingMode.HALF_EVEN;

public class CreditCard extends AbstractCard implements Debt {

    protected BigDecimal interestRate;

    public CreditCard(String name, Currency currency, BigDecimal balance, BigDecimal interestRate) {
        super(name, currency, balance);
        this.interestRate = interestRate;
    }

    @Override
    public BigDecimal getDebt() {
        return balance.add(balance.multiply(interestRate.divide(HUNDRED, HALF_EVEN)));
    }

}