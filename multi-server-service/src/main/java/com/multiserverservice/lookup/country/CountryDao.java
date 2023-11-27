package com.multiserverservice.lookup.country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryDao extends JpaRepository<CountryBean,Integer> {
    CountryBean findByCountryId(int countryId);
}
