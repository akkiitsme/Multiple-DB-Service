package com.multiserverservice.lookup.culture;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CultureDao extends JpaRepository<CultureBean,Integer> {
    CultureBean findByCultureId(int cultureId);
}
