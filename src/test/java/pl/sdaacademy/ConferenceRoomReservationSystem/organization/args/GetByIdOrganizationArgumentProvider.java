package pl.sdaacademy.ConferenceRoomReservationSystem.organization.args;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import pl.sdaacademy.ConferenceRoomReservationSystem.organization.Organization;

import java.util.Arrays;
import java.util.Collections;
import java.util.Optional;
import java.util.stream.Stream;

public class GetByIdOrganizationArgumentProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext extensionContext) throws Exception {
        return Stream.of(
                Arguments.of(
                        Arrays.asList(
                                new Organization("Intive", "IT Comapny"),
                                new Organization("Google", "IT Comapny"),
                                new Organization("Uber", "Delivery company")
                        ),
                        "Intive",
                        Optional.of(new Organization("Intive", "IT Comapny"))
                ),
                Arguments.of(
                        Collections.emptyList(),
                        "Intive",
                        Optional.empty()
                ),
                Arguments.of(
                        Arrays.asList(
                                new Organization("Intive", "IT Comapny"),
                                new Organization("Google", "IT Comapny"),
                                new Organization("Uber", "Delivery company")
                        ),
                        "Test",
                        Optional.empty()
                )
        );
    }
}
