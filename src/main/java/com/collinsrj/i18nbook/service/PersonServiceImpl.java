package com.collinsrj.i18nbook.service;

import com.collinsrj.i18nbook.entity.Person;
import com.collinsrj.i18nbook.model.Persons;
import com.collinsrj.i18nbook.repo.PersonRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
@Slf4j
public class PersonServiceImpl implements PersonService {
    private final PersonRepository personRepository;

    private static com.collinsrj.i18nbook.model.Person map(Person person) {
        com.collinsrj.i18nbook.model.Person result = new com.collinsrj.i18nbook.model.Person();
        result.setCreated(OffsetDateTime.of(person.getCreated(), ZoneOffset.UTC));
        result.setFamilyName(person.getFamilyName());
        result.setGivenName(person.getGivenName());
        result.setPhoneNumber(person.getPhoneNumber());
        result.setId(person.getResourceId());
        return result;
    }

    private static Person map(com.collinsrj.i18nbook.model.Person person) {
        Person result = new Person();
        result.setFamilyName(person.getFamilyName());
        result.setGivenName(person.getGivenName());
        result.setPhoneNumber(person.getPhoneNumber());
        return result;
    }

    @Override
    public Persons findPersons(Paging paging) {
        Page<Person> personPage = personRepository.findAll(paging.pageable());
        return new Persons()
                .count(personPage.getSize())
                .limit(paging.getLimit())
                .offset(paging.getOffset())
                .total(personPage.getTotalElements())
                .items(personPage.get().map(PersonServiceImpl::map).collect(Collectors.toList()));
    }

    @Override
    public com.collinsrj.i18nbook.model.Person createPerson(com.collinsrj.i18nbook.model.Person person) {
        return map(personRepository.save(map(person)));
    }

    @Override
    public Optional<com.collinsrj.i18nbook.model.Person> getPerson(UUID id) {
        Optional<Person> person = personRepository.findByResourceId(id);
        return person.map(PersonServiceImpl::map);
    }
}
