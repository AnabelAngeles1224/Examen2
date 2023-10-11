package com.example.ExamenSem10_Anabel_Angeles.application.useCase;

import com.example.ExamenSem10_Anabel_Angeles.domain.model.Person;
import com.example.ExamenSem10_Anabel_Angeles.domain.ports.in.PersonUseCase;
import com.example.ExamenSem10_Anabel_Angeles.domain.ports.out.PersonRepositoryPort;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public class PersonUseCaseImpl implements PersonUseCase {

    private final PersonRepositoryPort personRepositoryPort;
    public PersonUseCaseImpl(PersonRepositoryPort personRepositoryPort){
        this.personRepositoryPort = personRepositoryPort;
    }
    @Override
    public Person crearPerson(Person person) {
        return personRepositoryPort.savePerson(person);
    }
    @Override
    public Optional<Person> getPerson(Long id) {
        return Optional.empty();
    }

    @Override
    public List<Person> findAll() {
        return personRepositoryPort.getAll();
    }

    @Override
    public Optional<Person> updatePerson(Long id,Person person) {
        return personRepositoryPort.update(id,person);
    }

    @Override
    public Optional<Person> deletePerson(Long id) {
        return personRepositoryPort.deletePersonById(id);
    }


}
