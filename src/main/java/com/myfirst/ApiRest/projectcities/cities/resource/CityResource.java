package com.myfirst.ApiRest.projectcities.cities.resource;

import java.util.List;
import com.myfirst.ApiRest.projectcities.cities.entity.City;
import com.myfirst.ApiRest.projectcities.cities.repository.CityRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("cities")
public class CityResource {
    
    private final CityRepository repository;

    public CityResource(final CityRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public Page<City> cities( final Pageable page) {
        return repository.findAll(page);
    }

    @GetMapping("/{nome}")
    public List<City> getOne(@PathVariable String nome){
        return repository.findByName(nome);
    }
}
