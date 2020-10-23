package com.collinsrj.i18nbook.service;

import com.collinsrj.i18nbook.model.Person;
import com.collinsrj.i18nbook.model.Persons;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;


@Service
public interface PersonService {
    Persons findPersons(Paging paging);

    Person createPerson(Person person);

    Optional<Person> getPerson(UUID id);
}
