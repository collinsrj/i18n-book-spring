package com.collinsrj.i18nbook.entity;

import com.collinsrj.i18nbook.model.JobType;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(indexes = {@Index(columnList = "resourceId", unique = true)})
public class Job {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    /**
     * The date the job was recorded in the system
     */
    @CreatedDate
    @Column(nullable = false, updatable = false)
    LocalDateTime created;

    /**
     * The start date for the job in UTC
     */
    LocalDateTime startDateTime;

    @Enumerated(EnumType.STRING)
    JobType type;

    Money priceQuoted;
    @ManyToOne
    Person customer;

    /**
     * A UUID used to uniquely identify the job in the REST interface
     */
    @Column(nullable = false, unique = true, updatable = false)
    UUID resourceId = UUID.randomUUID();

}
