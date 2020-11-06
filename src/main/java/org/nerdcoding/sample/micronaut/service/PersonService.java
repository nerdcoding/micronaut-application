package org.nerdcoding.sample.micronaut.service;

import org.nerdcoding.sample.micronaut.pesistence.model.Person;

import javax.inject.Singleton;
import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Singleton
public class PersonService {

    public List<Person> findAllPersons() {
        return Collections.singletonList(createTestPerson());
    }

    public Optional<Person> findPersonByLastName(final String lastName) {
        return Optional.of(createTestPerson());
    }

    private Person createTestPerson() {
        final Person person = new Person();
        person.setFirstName("Heide");
        person.setLastName("Witzka");
        person.setEmail("heide@witzka@gmail.com");
        person.setDayOfBirth(LocalDate.now());

        return person;
    }

}
