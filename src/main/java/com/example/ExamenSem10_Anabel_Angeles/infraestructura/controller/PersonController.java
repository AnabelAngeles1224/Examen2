package com.example.ExamenSem10_Anabel_Angeles.infraestructura.controller;

import com.example.ExamenSem10_Anabel_Angeles.application.service.PersonService;
import com.example.ExamenSem10_Anabel_Angeles.domain.model.Person;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/person")
public class PersonController {


   private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping("/crearPerson")
    public void createPerson(@RequestBody(required = true) Person person){
        personService.crearPerson(person);
    }
    @GetMapping("/getAll")
    public List<Person> getAll(){
        return personService.findAll();
    }

    @PutMapping("/update/{personId}")
    public ResponseEntity<Person> updatePersonById(
            @PathVariable Long personId,
            @RequestBody Person person
    ){
        return personService.updatePerson(personId,person)
                .map(persona1 -> new ResponseEntity<>(person, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PutMapping("/delete/{personId}")
    public ResponseEntity<Person> deletePersonById(@PathVariable Long personId){
        return personService.deletePerson(personId)
                .map(persona1 -> new ResponseEntity<>(persona1,HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}

