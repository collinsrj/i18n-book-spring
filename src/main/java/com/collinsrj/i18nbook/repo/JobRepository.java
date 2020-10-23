package com.collinsrj.i18nbook.repo;

import com.collinsrj.i18nbook.entity.Job;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Optional;
import java.util.UUID;

public interface JobRepository extends PagingAndSortingRepository<Job, Long> {
    Page<Job> findAll(Pageable pageable);

    Optional<Job> findByResourceId(UUID resourceId);
}
