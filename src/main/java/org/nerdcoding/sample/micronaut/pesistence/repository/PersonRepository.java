package org.nerdcoding.sample.micronaut.pesistence.repository;


import org.nerdcoding.sample.micronaut.pesistence.model.Person;

import java.util.List;
import java.util.Optional;

public interface PersonRepository {

    Optional<Person> findByLastName(final String lastName);

    List<Person> findAll();

}
