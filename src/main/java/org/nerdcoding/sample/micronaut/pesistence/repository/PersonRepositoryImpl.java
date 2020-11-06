package org.nerdcoding.sample.micronaut.pesistence.repository;


import org.nerdcoding.sample.micronaut.pesistence.model.Person;

import io.micronaut.transaction.annotation.ReadOnly;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Optional;

@Singleton
public class PersonRepositoryImpl implements PersonRepository {

    private final EntityManager entityManager;

    @Inject
    public PersonRepositoryImpl(final EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @ReadOnly
    @Override
    public List<Person> findAll() {
        final TypedQuery<Person> query = entityManager.createQuery(
                "SELECT p FROM Person as p",
                Person.class
        );

        return query.getResultList();
    }

    @ReadOnly
    @Override
    public Optional<Person> findByLastName(final String lastName) {
        final TypedQuery<Person> query = entityManager.createQuery(
                "SELECT p FROM Person as p where p.lastName = :lastName",
                Person.class
        );
        query.setParameter("lastName", lastName);

        try {
            return Optional.of(query.getSingleResult());
        } catch (final NoResultException e) {
            return Optional.empty();
        }
    }
}
