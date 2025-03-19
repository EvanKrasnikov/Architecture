package ru.geographer29.interfaces;

import java.math.BigDecimal;

public interface BankProduct {

    /**
     * Пополнить баланс
     * @param sum Сумма на которую пополнить баланс
     */
    void replenishBalance(BigDecimal sum);

    /**
     * Получить баланс
     * @return значение баланса
     */
    BigDecimal getBalance();

}
