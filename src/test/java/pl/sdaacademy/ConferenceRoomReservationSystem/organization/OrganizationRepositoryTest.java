package pl.sdaacademy.ConferenceRoomReservationSystem.organization;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.orm.jpa.JpaSystemException;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import pl.sdaacademy.ConferenceRoomReservationSystem.organization.args.GetAllOrganizationArgumentProvider;
import pl.sdaacademy.ConferenceRoomReservationSystem.organization.args.GetByIdOrganizationArgumentProvider;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(SpringExtension.class)
@DataJpaTest
class OrganizationRepositoryTest {

    @Autowired
    OrganizationRepository organizationRepository;

    @Autowired
    TestEntityManager testEntityManager;

    @ParameterizedTest
    @ArgumentsSource(GetAllOrganizationArgumentProvider.class)
    void when_arg_0_date_are_available_in_repo_then_all_should_return_arg_1_list(List<Organization> arg0,
                                                                                 List<Organization> arg1) {

        //given
        arg0.forEach(o -> {
            testEntityManager.persist(o);
        });


        //when
        List<Organization> results = organizationRepository.findAll();
        //then
        assertEquals(arg0, results);
    }

    @ParameterizedTest
    @ArgumentsSource(GetByIdOrganizationArgumentProvider.class)
    void when_find_by_arg_1_when_arg_0_list_available_then_arg2_item_should_be_returned(List<Organization> arg0,
                                                                                        String arg1,
                                                                                        Optional<Organization> arg2) {
        //given
        arg0.forEach(o -> testEntityManager.persist(o));
        //when
        Optional<Organization> result = organizationRepository.findById(arg1);
        //then
        assertEquals(arg2, result);
    }

    @Test
    void when_save_arg_0_to_repo_then_it_should_be_stored_properly() {
        //given
        Organization arg0 = new Organization("Intive", "IT company");
        //when
        organizationRepository.save(arg0);
        //then
        assertEquals(arg0, testEntityManager.find(Organization.class, "Intive"));
    }

    @Test
    void when_save_arg_0_with_wrong_primary_ket_then_exception_should_be_thrown() {
        //given
        Organization arg0 = new Organization(null, "IT Company");
        //when
        //then
        assertThrows(JpaSystemException.class, () -> {
            organizationRepository.save(arg0);
        });
    }
}