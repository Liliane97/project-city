package com.myfirst.ApiRest.projectcities.countries.resource;

import java.util.Optional;
import com.myfirst.ApiRest.projectcities.countries.entity.Country;
import com.myfirst.ApiRest.projectcities.countries.repositories.CountryRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/countries")
public class CountryResourse {
  
    private CountryRepository repository;

    public CountryResourse(  CountryRepository repository) {
        this.repository = repository;
    }
    @GetMapping
    public Page<Country> countries(Pageable page){
        return repository.findAll(page);
        
    }
    @GetMapping("/{nome}")
    public ResponseEntity getOne(@PathVariable String nome) {
       Optional<Country>optional = repository.findByName(nome);
    
       if (optional.isPresent()) {
        return ResponseEntity.ok().body(optional.get());
       }else{
           return ResponseEntity.notFound().build();
       }
    
    }
}
