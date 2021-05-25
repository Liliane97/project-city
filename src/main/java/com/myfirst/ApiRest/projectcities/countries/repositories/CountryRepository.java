package com.myfirst.ApiRest.projectcities.countries.repositories;

import java.util.Optional;
import com.myfirst.ApiRest.projectcities.countries.entity.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country,Long> {

    Optional<Country> findByName(String nome);

}
