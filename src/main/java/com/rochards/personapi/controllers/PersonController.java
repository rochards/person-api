package com.rochards.personapi.controllers;

import com.rochards.personapi.entities.Person;
import com.rochards.personapi.repositories.PersonRepository;
import com.rochards.personapi.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/people") // caminho principal da API
public class PersonController {

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private PersonService personService;

    @GetMapping
    public List<Person> getAll() {
        return personRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<Person> create(@RequestBody Person person) {
        var createdPerson = personService.createPerson(person);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdPerson);
    }
}
