package com.multipledb.transaction.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "trx_users")
@AllArgsConstructor
@NoArgsConstructor
public class UserBean {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;
    private String email;
    private String name;
    private String phoneNo;
    private int countryId;
    private Integer status = 1;
    private Date createdOn = new Date();
}
