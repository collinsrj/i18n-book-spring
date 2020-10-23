package com.collinsrj.i18nbook.entity;

import javax.persistence.*;
import java.util.Locale;

@Entity
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    /**
     * The street address. For example, 1600 Amphitheatre Pkwy.
     */
    @Column(nullable = false)
    String streetAddress;
    /**
     * The two-letter ISO 3166-1 alpha-2 country code.
     */
    @Column(length = 2, nullable = false)
    @Enumerated(EnumType.STRING)
    Locale.IsoCountryCode country;
    /**
     * The locality in which the street address is, and which is in the region. For example, Mountain View.
     */
    @Column
    String locality;
    /**
     * The region in which the locality is, and which is in the country. For example, California or another appropriate
     * first-level Administrative division
     */
    @Column
    String region;
    /**
     * The post office box number for PO box addresses.
     */
    @Column
    String postOfficeBoxNumber;
    /**
     * The postal code. For example, 94043
     */
    @Column
    String postalCode;

}
