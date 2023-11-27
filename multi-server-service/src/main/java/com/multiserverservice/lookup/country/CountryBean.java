package com.multiserverservice.lookup.country;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table(name = "lu_country")
@AllArgsConstructor
@NoArgsConstructor
public class CountryBean {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "country_id")
    private int countryId;
    @Column(name = "country_name")
    private String countryName;
    @Column(name = "country_code")
    private String countryCode;
}
