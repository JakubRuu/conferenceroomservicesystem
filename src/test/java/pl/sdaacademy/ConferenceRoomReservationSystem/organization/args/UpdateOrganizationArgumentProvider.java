package pl.sdaacademy.ConferenceRoomReservationSystem.organization.args;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import pl.sdaacademy.ConferenceRoomReservationSystem.organization.Organization;

import java.util.stream.Stream;

public class UpdateOrganizationArgumentProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext extensionContext) throws Exception {
        return Stream.of(
                //name
                //existing org
                //to update
                //expected
                Arguments.of(
                        "Intive",
                        new Organization("Intive", "Delivery"),
                        new Organization(null, "IT Company"),
                        new Organization("Intive", "IT Company")
                ),
                Arguments.of(
                        "Intive",
                        new Organization("Intive", "Delivery"),
                        new Organization("Tieto", null),
                        new Organization("Tieto", "Delivery")
                ),
                Arguments.of(
                        "Intive",
                        new Organization("Tieto", "Delivery"),
                        new Organization("Tieto", "IT Company"),
                        new Organization("Tieto", "IT Company")

                ),
                Arguments.of(
                        "Intive",
                        new Organization("Intive", "Delivery"),
                        new Organization(null, null),
                        new Organization("Intive", "Delivery")
                )
        );
    }
}
