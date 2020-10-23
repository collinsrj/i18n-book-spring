package com.collinsrj.i18nbook.repo;

import com.collinsrj.i18nbook.entity.Person;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Optional;
import java.util.UUID;

public interface PersonRepository extends PagingAndSortingRepository<Person, Long> {
    Optional<Person> findByResourceId(UUID resourceId);

    Page<Person> findAll(Pageable pageable);
}
