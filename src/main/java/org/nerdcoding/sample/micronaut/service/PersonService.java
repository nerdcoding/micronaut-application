package org.nerdcoding.sample.micronaut.service;

import org.nerdcoding.sample.micronaut.pesistence.model.Person;
import org.nerdcoding.sample.micronaut.pesistence.repository.PersonRepository;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.List;
import java.util.Optional;

@Singleton
public class PersonService {

    private final PersonRepository personRepository;

    @Inject
    public PersonService(final PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public List<Person> findAllPersons() {
        return personRepository.findAll();
    }

    public Optional<Person> findPersonByLastName(final String lastName) {
        return personRepository.findByLastName(lastName);
    }

}
