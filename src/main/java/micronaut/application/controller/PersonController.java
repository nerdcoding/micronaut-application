package micronaut.application.controller;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.PathVariable;
import micronaut.application.pesistence.model.Person;
import micronaut.application.service.PersonService;

import java.util.List;

@Controller("/persons")
public class PersonController {

    private final PersonService personService;

    public PersonController(final PersonService personService) {
        this.personService = personService;
    }

    @Get(produces = MediaType.APPLICATION_JSON)
    public HttpResponse<List<Person>> findAllPersons() {
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
