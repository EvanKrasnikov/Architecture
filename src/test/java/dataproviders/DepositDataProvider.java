package dataproviders;

import org.instancio.Instancio;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import ru.geographer29.entities.Deposit;

import java.util.stream.Stream;

public class DepositDataProvider implements ArgumentsProvider {

    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
        return Stream.of(
                Arguments.of(Instancio.create(Deposit.class)),
                Arguments.of(Instancio.create(Deposit.class))
        );
    }

}
