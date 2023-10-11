package com.example.ExamenSem10_Anabel_Angeles.domain.ports.out;

import com.example.ExamenSem10_Anabel_Angeles.domain.model.Person;
import com.example.ExamenSem10_Anabel_Angeles.domain.model.User;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface PersonRepositoryPort {

    Person savePerson(Person person);
    Optional<Person> findPersonId(Long id);
    List<Person> getAll();
    Optional<Person> update(Long id,Person person);

    Optional<Person> deletePersonById(Long id);
}
