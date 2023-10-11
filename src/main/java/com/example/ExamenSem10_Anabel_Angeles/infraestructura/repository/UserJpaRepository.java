package com.example.ExamenSem10_Anabel_Angeles.infraestructura.repository;

import com.example.ExamenSem10_Anabel_Angeles.infraestructura.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface UserJpaRepository extends JpaRepository<UserEntity, Long> {
    UserEntity findByUsuario(String usuario);
}
