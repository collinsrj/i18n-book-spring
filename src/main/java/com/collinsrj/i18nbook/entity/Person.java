package com.collinsrj.i18nbook.entity;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Data
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(indexes = {@Index(columnList = "resourceId", unique = true)})
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    /**
     * Given name. In the U.S., the first name of a Person.
     */
    @Column
    String givenName;
    /**
     * Family name. In the U.S., the last name of a Person.
     */
    @Column
    String familyName;
    /**
     * E164 formatted phone number
     */
    @Column(nullable = false)
    String phoneNumber;
    /**
     * The address for the job
     */
    @ManyToOne
    Address address;
    @OneToMany(mappedBy = "customer")
    List<Job> jobs;

    /**
     * A UUID used to uniquely identify the person in the REST interface
     */
    @Column(nullable = false, unique = true, updatable = false)
    UUID resourceId = UUID.randomUUID();

    /**
     * The date the job was recorded in the system
     */
    @CreatedDate
    @Column(nullable = false, updatable = false)
    LocalDateTime created;
}
