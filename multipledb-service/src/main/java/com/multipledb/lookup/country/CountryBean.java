package com.multipledb.lookup.country;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "lu_country")
@AllArgsConstructor
@NoArgsConstructor
public class CountryBean {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int countryId;
    private String countryName;
    private String countryCode;
    private Integer status=1;
    private Date createdOn = new Date();
}




