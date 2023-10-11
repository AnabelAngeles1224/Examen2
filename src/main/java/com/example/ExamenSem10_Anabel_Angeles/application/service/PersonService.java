package com.example.ExamenSem10_Anabel_Angeles.application.service;

import com.example.ExamenSem10_Anabel_Angeles.domain.model.Person;
import com.example.ExamenSem10_Anabel_Angeles.domain.ports.in.PersonUseCase;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;


import java.util.List;
import java.util.Optional;


public class PersonService implements PersonUseCase {

    private final PersonUseCase personUseCase;

    public PersonService(PersonUseCase personUseCase) {
        this.personUseCase = personUseCase;
    }

    @Override
    public Person crearPerson(Person person) {
        return personUseCase.crearPerson(person);
    }

    @Override
    public Optional<Person> getPerson(Long id) {
        return Optional.empty();
    }

    @Override
    public List<Person> findAll() {
        return personUseCase.findAll();
    }

    @Override
    public Optional<Person> updatePerson(Long id,Person person) {
        return personUseCase.updatePerson(id,person);
    }

    @Override
    public Optional<Person> deletePerson(Long id) {
        return personUseCase.deletePerson(id);
    }


}
