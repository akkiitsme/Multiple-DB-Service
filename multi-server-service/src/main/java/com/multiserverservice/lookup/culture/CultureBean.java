package com.multiserverservice.lookup.culture;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table(name = "lu_culture")
@AllArgsConstructor
@NoArgsConstructor
public class CultureBean {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "culture_id")
    private int cultureId;
    @Column(name = "country_id")
    private int countryId;
    @Column(name = "currency_code")
    private String currencyCode;
    @Column(name = "lang_id")
    private String langId;
}
