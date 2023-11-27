package com.multiserverservice.transaction.verification;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table(name = "ob_user_mobile_verification")
@AllArgsConstructor
@NoArgsConstructor
public class MobileVerificationBean {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "mobile_verification_id")
    private int mobileVerificationId;
    @Column(name = "panelist_id")
    private int panelistId;
    @Column(name = "mobile_no")
    private String mobileNo;

}
