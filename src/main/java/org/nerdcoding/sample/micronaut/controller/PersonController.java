package org.nerdcoding.sample.micronaut.controller;

import org.nerdcoding.sample.micronaut.pesistence.model.Person;
import org.nerdcoding.sample.micronaut.service.PersonService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.PathVariable;

import javax.inject.Inject;
import java.util.List;

@Controller("/persons")
public class PersonController {

    private static final Logger LOG = LoggerFactory.getLogger(PersonController.class);

    private final PersonService personService;

    @Inject
    public PersonController(final PersonService personService) {
        this.personService = personService;
    }

    @Get(produces = MediaType.APPLICATION_JSON)
    public HttpResponse<List<Person>> findAllPersons() {
        LOG.debug("REST endpoint '/persons' called");

        return HttpResponse
                .ok()
                .body(personService.findAllPersons());
    }

    @Get(value = "/{lastName}", produces = MediaType.APPLICATION_JSON)
    public HttpResponse<Person> findPersonByLastName(
            @PathVariable final String lastName) {

        return personService.findPersonByLastName(lastName)
                .map(person -> HttpResponse
                        .ok()
                        .body(person)
                ).orElse(HttpResponse
                        .notFound()
                );
    }

}
