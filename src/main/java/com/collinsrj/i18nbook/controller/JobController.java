package com.collinsrj.i18nbook.controller;

import com.collinsrj.i18nbook.api.JobsApi;
import com.collinsrj.i18nbook.model.Job;
import com.collinsrj.i18nbook.model.Jobs;
import com.collinsrj.i18nbook.model.Person;
import com.collinsrj.i18nbook.service.JobService;
import com.collinsrj.i18nbook.service.Paging;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.net.URI;
import java.util.List;

import static org.springframework.http.ResponseEntity.created;
import static org.springframework.http.ResponseEntity.ok;

@AllArgsConstructor
@RestController
public class JobController implements JobsApi {
    private final JobService jobService;

    @Override
    public ResponseEntity<Void> createJob(@Valid Job job) throws Exception {
        Job created = jobService.createJob(job);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest().path("/{id}")
                .buildAndExpand(created.getId()).toUri();
        return created(location).build();
    }

    @Override
    public ResponseEntity<Jobs> findJobs(@Min(0) @Valid Integer offset, @Min(0) @Max(100) @Valid Integer limit, @Valid List<String> sort) throws Exception {
        return ok(jobService.findJobs(
                new Paging(limit, offset, sort)));
    }

//    public ResponseEntity<Void> createJob(@Valid Job job) throws Exception {
//        Job created = jobService.createJob(job);
//        URI location = ServletUriComponentsBuilder
//                .fromCurrentRequest().path("/{id}")
//                .buildAndExpand(created.getId()).toUri();
//        return created(location).build();
//    }
//
//    @Override
//    public ResponseEntity<Jobs> findJobs(@Valid Integer offset, @Valid Integer limit, @Valid List<String> sort) throws Exception {

//    }
}
