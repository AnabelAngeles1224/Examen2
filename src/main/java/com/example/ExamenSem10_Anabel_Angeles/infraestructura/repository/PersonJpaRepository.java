package com.example.ExamenSem10_Anabel_Angeles.infraestructura.repository;

import com.example.ExamenSem10_Anabel_Angeles.infraestructura.entity.PersonEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;


@Component
public interface PersonJpaRepository extends JpaRepository<PersonEntity, Long> {
    PersonEntity findByNombre(String nombre);
}
