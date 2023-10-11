package com.example.ExamenSem10_Anabel_Angeles.infraestructura.config;

import com.example.ExamenSem10_Anabel_Angeles.application.service.PersonService;
import com.example.ExamenSem10_Anabel_Angeles.application.service.UserService;
import com.example.ExamenSem10_Anabel_Angeles.application.useCase.PersonUseCaseImpl;
import com.example.ExamenSem10_Anabel_Angeles.application.useCase.UserUseCaseImpl;
import com.example.ExamenSem10_Anabel_Angeles.domain.ports.out.PersonRepositoryPort;
import com.example.ExamenSem10_Anabel_Angeles.domain.ports.out.UserRepositoryPort;
import com.example.ExamenSem10_Anabel_Angeles.infraestructura.repository.PersonJpaRepositoryAdapter;
import com.example.ExamenSem10_Anabel_Angeles.infraestructura.repository.UserJpaRepositoryAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {
    @Bean
    public UserService userService(UserRepositoryPort userRepositoryPort){
        return new UserService(new UserUseCaseImpl(userRepositoryPort));
    }
    @Bean
    public UserRepositoryPort userRepositoryPort(UserJpaRepositoryAdapter userJpaRepositoryAdapter){
        return userJpaRepositoryAdapter;
    }

    @Bean
    public PersonService personService(PersonRepositoryPort personRepositoryPort){
        return new PersonService(new PersonUseCaseImpl(personRepositoryPort));
    }
    @Bean
    public PersonRepositoryPort personRepositoryPort(PersonJpaRepositoryAdapter personJpaRepositoryAdapter){
        return personJpaRepositoryAdapter;
    }
}
