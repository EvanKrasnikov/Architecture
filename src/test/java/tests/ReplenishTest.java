package tests;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import ru.geographer29.entities.CreditCard;
import ru.geographer29.entities.CurrencyDebitCard;
import ru.geographer29.entities.DebitCard;
import ru.geographer29.entities.Deposit;
import ru.geographer29.interfaces.BankProduct;

import java.math.BigDecimal;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.instancio.Instancio.create;

public class ReplenishTest {

    @ParameterizedTest
    @MethodSource("products")
    public void shouldReplenishBalance(BankProduct entity, BigDecimal addend) {
        BigDecimal expected = entity.getBalance().add(addend);

        entity.replenishBalance(addend);

        assertThat(entity.getBalance()).isEqualTo(expected);
    }

    private static Stream<Arguments> products() {
        return Stream.of(
                Arguments.of(create(CreditCard.class), create(BigDecimal.class)),
                Arguments.of(create(DebitCard.class), create(BigDecimal.class)),
                Arguments.of(create(CurrencyDebitCard.class), create(BigDecimal.class)),
                Arguments.of(create(Deposit.class), create(BigDecimal.class))
        );
    }

}
