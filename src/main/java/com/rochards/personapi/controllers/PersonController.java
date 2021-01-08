package com.rochards.personapi.controllers;

import com.rochards.personapi.dto.request.PersonDTO;
import com.rochards.personapi.entities.Person;
import com.rochards.personapi.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/v1/people") // caminho principal da API
public class PersonController {

    @Autowired
    private PersonService personService;

    @GetMapping
    public List<PersonDTO> getAll() {
        return personService.listAll();
    }

    @PostMapping
    public ResponseEntity<PersonDTO> create(@Valid @RequestBody PersonDTO personDTO) {
        var createdPerson = personService.createPerson(personDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdPerson);
    }
}
