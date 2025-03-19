package tests;

import dataproviders.DepositDataProvider;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;
import ru.geographer29.interfaces.Close;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

public class CloseTest {

    @ParameterizedTest
    @ArgumentsSource(DepositDataProvider.class)
    public void shouldCloseDeposit(Close entity) {
        entity.close();

        assertThat(entity.getBalance()).isEqualTo(BigDecimal.ZERO);
    }

}
