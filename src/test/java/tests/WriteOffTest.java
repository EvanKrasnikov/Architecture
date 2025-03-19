package tests;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import ru.geographer29.entities.CreditCard;
import ru.geographer29.entities.CurrencyDebitCard;
import ru.geographer29.entities.DebitCard;
import ru.geographer29.interfaces.WriteOff;

import java.math.BigDecimal;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.instancio.Instancio.create;

public class WriteOffTest {

    @ParameterizedTest
    @MethodSource("cards")
    public void shouldWriteOffBalance(WriteOff entity, BigDecimal subtrahend) {
        BigDecimal expected = entity.getBalance().subtract(subtrahend);

        entity.writeOff(subtrahend);

        assertThat(entity.getBalance()).isEqualTo(expected);
    }

    private static Stream<Arguments> cards() {
        return Stream.of(
                Arguments.of(create(CreditCard.class), create(BigDecimal.class)),
                Arguments.of(create(DebitCard.class), create(BigDecimal.class)),
                Arguments.of(create(CurrencyDebitCard.class), create(BigDecimal.class))
        );
    }

}
