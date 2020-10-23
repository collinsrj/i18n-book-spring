package com.collinsrj.i18nbook.service;

import com.collinsrj.i18nbook.model.Job;
import com.collinsrj.i18nbook.model.Jobs;

import java.util.Optional;
import java.util.UUID;


public interface JobService {
    Job createJob(Job job);

    Jobs findJobs(Paging paging);

    Optional<Job> getJob(UUID id);
}
