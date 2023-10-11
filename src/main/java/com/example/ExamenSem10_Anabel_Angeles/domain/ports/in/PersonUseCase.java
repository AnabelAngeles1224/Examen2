package com.example.ExamenSem10_Anabel_Angeles.domain.ports.in;

import com.example.ExamenSem10_Anabel_Angeles.domain.model.Person;
import org.springframework.http.ResponseEntity;


import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface PersonUseCase {

    Person crearPerson(Person person);
    Optional<Person> getPerson(Long id);
    List<Person> findAll();
    Optional<Person> updatePerson(Long id,Person person);
    Optional<Person> deletePerson(Long id);
}
