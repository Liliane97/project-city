package com.myfirst.ApiRest.projectcities.states.resource;

import java.util.List;
import java.util.Optional;
import com.myfirst.ApiRest.projectcities.states.entity.State;
import com.myfirst.ApiRest.projectcities.states.repository.StateRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/states")
public class StateResource {
    
    private final StateRepository repository;

    public StateResource(final StateRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<State>states() {
        return repository.findAll();
    }
 
   @GetMapping("/{nome}")
    public ResponseEntity getOne(@PathVariable String nome) {
       Optional<State>optional = repository.findByName(nome);
       if (optional.isPresent()) {
        return ResponseEntity.ok().body(optional.get());
       }else{
           return ResponseEntity.notFound().build();
       }
    }
}


