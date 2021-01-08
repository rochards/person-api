package com.rochards.personapi.services;

import com.rochards.personapi.dto.request.PersonDTO;
import com.rochards.personapi.entities.Person;
import com.rochards.personapi.mappers.PersonMapper;
import com.rochards.personapi.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    private final PersonMapper personMapper = PersonMapper.INSTANCE;

    public Person createPerson(PersonDTO personDTO) {
        var person = personMapper.toModel(personDTO); // isso faz o parse automatico das informacoes
        return personRepository.save(person);
    }
}
