package tests;

import org.instancio.Instancio;
import org.instancio.Select;
import org.instancio.TargetSelector;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import ru.geographer29.entities.CreditCard;
import ru.geographer29.interfaces.Debt;

import java.math.BigDecimal;
import java.util.stream.Stream;

import static java.math.RoundingMode.HALF_EVEN;
import static org.assertj.core.api.Assertions.assertThat;
import static ru.geographer29.interfaces.Debt.HUNDRED;

public class GetDebtTest {

    @ParameterizedTest
    @MethodSource("creditCards")
    public void shouldGetDebt(Debt entity, BigDecimal interestRate) {
        BigDecimal balance = entity.getBalance();
        BigDecimal expectedDebt = balance.add(balance.multiply(interestRate.divide(HUNDRED, HALF_EVEN)));

        assertThat(entity.getDebt()).isEqualTo(expectedDebt);
    }

    private static Stream<Arguments> creditCards() {
        BigDecimal interestRate = Instancio.create(BigDecimal.class);
        TargetSelector fieldSelector = Select.field(CreditCard.class, "interestRate");

        return Stream.of(
            Arguments.of(
                    Instancio.of(CreditCard.class).set(fieldSelector, interestRate).create(),
                    interestRate
            ),
            Arguments.of(
                    Instancio.of(CreditCard.class).set(fieldSelector, interestRate).create(),
                    interestRate
            ),
            Arguments.of(
                    Instancio.of(CreditCard.class).set(fieldSelector, interestRate).create(),
                    interestRate
            )
        );
    }

}
