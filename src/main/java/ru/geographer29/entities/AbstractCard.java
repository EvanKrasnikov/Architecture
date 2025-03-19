package ru.geographer29.entities;

import ru.geographer29.enums.Currency;
import ru.geographer29.interfaces.WriteOff;

import java.math.BigDecimal;

public abstract class AbstractCard extends AbstractBankProduct implements WriteOff {

    public AbstractCard(String name, Currency currency, BigDecimal balance) {
        super(name, currency, balance);
    }

    @Override
    public void writeOff(BigDecimal sum) {
        balance = balance.subtract(sum);
    }

}
