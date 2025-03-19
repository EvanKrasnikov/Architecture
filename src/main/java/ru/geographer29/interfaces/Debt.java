package ru.geographer29.interfaces;

import java.math.BigDecimal;

public interface Debt extends BankProduct {

    BigDecimal HUNDRED = BigDecimal.valueOf(100);

    /**
     * Получить задолжность
     * @return значение задолжности
     */
    BigDecimal getDebt();

}
