package com.rochards.personapi.services;

import com.rochards.personapi.dto.request.PersonDTO;
import com.rochards.personapi.exceptions.types.PersonNotFoundException;
import com.rochards.personapi.mappers.PersonMapper;
import com.rochards.personapi.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    private final PersonMapper personMapper = PersonMapper.INSTANCE;

    public PersonDTO createPerson(PersonDTO personDTO) {

        var person = personMapper.toModel(personDTO); // isso faz o parse automatico das informacoes

        var createdPerson = personRepository.save(person);

        return personMapper.toDTO(createdPerson);
    }

    public List<PersonDTO> listAll() {
        return personRepository.findAll()
                .stream().map(personMapper::toDTO)
                .collect(Collectors.toList());
    }

    public PersonDTO findById(Long id)  {

        var person = personRepository.findById(id)
                .orElseThrow(() -> new PersonNotFoundException(id));

        return personMapper.toDTO(person);
    }

    public void deleteById(Long id) {

        if (!personRepository.existsById(id)) {
            throw new PersonNotFoundException(id);
        }
        personRepository.deleteById(id);
    }
}
