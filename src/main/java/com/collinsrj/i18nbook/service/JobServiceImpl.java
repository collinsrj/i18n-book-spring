package com.collinsrj.i18nbook.service;

import com.collinsrj.i18nbook.entity.Money;
import com.collinsrj.i18nbook.entity.Person;
import com.collinsrj.i18nbook.model.Job;
import com.collinsrj.i18nbook.model.JobPriceQuoted;
import com.collinsrj.i18nbook.model.JobType;
import com.collinsrj.i18nbook.model.Jobs;
import com.collinsrj.i18nbook.repo.JobRepository;
import com.collinsrj.i18nbook.repo.PersonRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;


@AllArgsConstructor
@Service
@Slf4j
public class JobServiceImpl implements JobService {
    private final JobRepository jobRepository;
    private final PersonRepository personRepository;

    private static Job map(com.collinsrj.i18nbook.entity.Job job) {
        Job result = new Job();
        result.setCreated(OffsetDateTime.of(job.getCreated(), ZoneOffset.UTC));
        result.setCustomer(job.getCustomer().getResourceId());
        result.setPriceQuoted(map(job.getPriceQuoted()));
        result.setType(job.getType());
        return result;
    }

    private static JobPriceQuoted map(Money money) {
        return new JobPriceQuoted()
                .amount(money.getAmount().doubleValue())
                .currency(money.getCurrency().getCurrencyCode());
    }

    private static Money map(JobPriceQuoted priceQuoted) {
        return new Money(BigDecimal.valueOf(priceQuoted.getAmount()),
                priceQuoted.getCurrency());
    }

    @Override
    public Job createJob(final Job job) {
        return map(jobRepository.save(map(job)));
    }

    @Override
    public Jobs findJobs(Paging paging) {
        Page<com.collinsrj.i18nbook.entity.Job> jobs = jobRepository.findAll(paging.pageable());
        return new Jobs()
                .count(jobs.getSize())
                .limit(paging.getLimit())
                .offset(paging.getOffset())
                .total(jobs.getTotalElements())
                .items(jobs.get().map(JobServiceImpl::map).collect(Collectors.toList()));
    }

    @Override
    public Optional<Job> getJob(UUID id) {
        Optional<com.collinsrj.i18nbook.entity.Job> job = jobRepository.findByResourceId(id);
        return job.map(JobServiceImpl::map);
    }

    /**
     * @param job
     * @return
     */
    private com.collinsrj.i18nbook.entity.Job map(Job job) {
        com.collinsrj.i18nbook.entity.Job result = new com.collinsrj.i18nbook.entity.Job();
        Optional<Person> customer = personRepository.findByResourceId(job.getCustomer());
        customer.ifPresent(result::setCustomer);
        result.setPriceQuoted(map(job.getPriceQuoted()));
        result.setStartDateTime(job.getStartDateTime().toLocalDateTime());
        return result;
    }
}
