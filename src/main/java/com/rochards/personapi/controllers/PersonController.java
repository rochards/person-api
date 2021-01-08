package com.rochards.personapi.controllers;

import com.rochards.personapi.dto.request.PersonDTO;
import com.rochards.personapi.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/v1/people") // caminho principal da API
//@AllArgsConstructor(onConstrucutor = @__(Autowired)) anotacao do lambok para fazer injecao quando tem muitas pra fazer
public class PersonController {

    @Autowired
    private PersonService personService;

    @GetMapping
    public List<PersonDTO> getAll() {
        return personService.listAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PersonDTO> findById(@PathVariable Long id) {
        var personDTO = personService.findById(id);
        return ResponseEntity.ok(personDTO);
    }

    @PostMapping
    public ResponseEntity<PersonDTO> create(@Valid @RequestBody PersonDTO personDTO) {
        var createdPerson = personService.createPerson(personDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdPerson);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PersonDTO> updateByID(@PathVariable Long id, @Valid @RequestBody PersonDTO personDTO) {
        var updatedPerson = personService.updateById(id, personDTO);
        return ResponseEntity.ok(personDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        personService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
