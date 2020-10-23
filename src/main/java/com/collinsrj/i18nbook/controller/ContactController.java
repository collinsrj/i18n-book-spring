package com.collinsrj.i18nbook.controller;

import com.collinsrj.i18nbook.api.ContactsApi;
import com.collinsrj.i18nbook.model.Person;
import com.collinsrj.i18nbook.model.Persons;
import com.collinsrj.i18nbook.service.Paging;
import com.collinsrj.i18nbook.service.PersonService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.net.URI;
import java.util.List;
import java.util.UUID;

import static org.springframework.http.ResponseEntity.created;
import static org.springframework.http.ResponseEntity.ok;

@AllArgsConstructor
@RestController
public class ContactController implements ContactsApi {
    private final PersonService personService;

    @Override
    public ResponseEntity<Void> createContact(@Valid Person person) throws Exception {
        Person created = personService.createPerson(person);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest().path("/{id}")
                .buildAndExpand(created.getId()).toUri();
        return created(location).build();
    }

    @Override
    public ResponseEntity<Persons> findContacts(@Min(0) @Valid Integer offset, @Min(0) @Max(100) @Valid Integer limit, @Valid List<String> sort) throws Exception {
        return ok(personService.findPersons(
                new Paging(limit, offset, sort)));
    }

//    @Override
//    public ResponseEntity<Person> getContact(UUID id) throws Exception {
//        personService.getPerson(id).map(ResponseEntity::ok);
//        return null;
//    }

}
