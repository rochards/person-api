package com.rochards.personapi.services;

import com.rochards.personapi.entities.Person;
import com.rochards.personapi.mappers.PersonMapper;
import com.rochards.personapi.repositories.PersonRepository;
import com.rochards.personapi.utils.PersonUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.ArgumentMatchers.any;

// essa extensao vai nos ajudar a criar um fake de personRepository para os testes unitarios
@ExtendWith(MockitoExtension.class)
public class PersonServiceTest {

    @Mock
    private PersonRepository personRepository;

    @InjectMocks
    private PersonService personService;

    private final PersonMapper personMapper = PersonMapper.INSTANCE;

    @Test
    void testGivenPersonDTOThenReturnPersonEntity() {
        var personDTO = PersonUtils.createFakeDTO();
        var expectedSavedPerson = PersonUtils.createFakeEntity();

        Mockito.when(personRepository.save(any(Person.class))).thenReturn(expectedSavedPerson);

        var createdPerson = personService.createPerson(personDTO);

        Assertions.assertEquals(expectedSavedPerson, personMapper.toModel(createdPerson));
    }
}
