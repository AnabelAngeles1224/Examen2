package com.example.ExamenSem10_Anabel_Angeles.infraestructura.repository;

import com.example.ExamenSem10_Anabel_Angeles.domain.model.Person;

import com.example.ExamenSem10_Anabel_Angeles.domain.ports.out.PersonRepositoryPort;
import com.example.ExamenSem10_Anabel_Angeles.infraestructura.entity.PersonEntity;
import com.example.ExamenSem10_Anabel_Angeles.infraestructura.entity.UserEntity;
import org.springframework.stereotype.Component;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class PersonJpaRepositoryAdapter implements PersonRepositoryPort {

    private final PersonJpaRepository personJpaRepository;

    public PersonJpaRepositoryAdapter(PersonJpaRepository personJpaRepository) {
        this.personJpaRepository = personJpaRepository;
    }


    @Override
    public Person savePerson(Person person) {
        PersonEntity personEntity = PersonEntity.fromDomainModel(person);
        PersonEntity savePersonEntity = personJpaRepository.save(personEntity);
        return savePersonEntity.toDomainModel();
    }

    @Override
    public Optional<Person> findPersonId(Long id) {
        return Optional.empty();
    }

    @Override
    public List<Person> getAll() {
        List<PersonEntity> lista = personJpaRepository.findAll();
        List<Person> listaFinal = new ArrayList<>();
        for(PersonEntity personEntity : lista){
            listaFinal.add(personEntity.toDomainModel());
        }
        return listaFinal;
    }

    @Override
    public Optional<Person> update(Long id,Person person) {
        if (personJpaRepository.existsById(id)){
            person.setId(id);
            PersonEntity personaEntity= PersonEntity.fromDomainModel(person);
            PersonEntity updatePersonaEntity = personJpaRepository.save(personaEntity);
            return Optional.of(updatePersonaEntity.toDomainModel());
        }

        return Optional.empty();
    }

    @Override
    public Optional<Person> deletePersonById(Long id) {
        Optional<PersonEntity> personEntityOptional = personJpaRepository.findById(id);

        if (personEntityOptional.isPresent()) {
            PersonEntity personEntity = personEntityOptional.get();
            personEntity.setEstado(0);
            PersonEntity updatePersonEntity = personJpaRepository.save(personEntity);
            return Optional.of(updatePersonEntity.toDomainModel());
        }

        return Optional.empty();
    }
}
