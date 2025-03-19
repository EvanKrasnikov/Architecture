package ru.geographer29.interfaces;

import java.math.BigDecimal;

public interface WriteOff extends BankProduct {

    /**
     * Списание суммы
     * @param sum Сумма, которую необходимо списать
     */
    void writeOff(BigDecimal sum);

}
