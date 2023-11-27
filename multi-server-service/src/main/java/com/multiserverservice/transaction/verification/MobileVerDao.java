package com.multiserverservice.transaction.verification;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MobileVerDao extends JpaRepository<MobileVerificationBean,Integer> {
}
