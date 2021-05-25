package com.myfirst.ApiRest.projectcities.states.repository;

import java.util.Optional;
import com.myfirst.ApiRest.projectcities.states.entity.State;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StateRepository extends JpaRepository<State, Long> {
    Optional<State> findByName(String nome);    
}


