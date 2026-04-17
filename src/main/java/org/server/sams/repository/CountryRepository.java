package org.server.sams.repository;

import org.server.sams.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface CountryRepository extends JpaRepository<Country, Integer> {


    @Query("select country from Country country")
    List<Country> findAllCountry();


    @Query("select country from Country country where country.id = :id")
    Optional<Country> findCountryById(Integer id);

    @Query("select country from Country country where country.name = :name")
    Optional<Country> findCountryByName(String name);
}
