package com.rochards.personapi.utils;

import com.rochards.personapi.dto.request.PersonDTO;
import com.rochards.personapi.entities.Person;

import java.time.LocalDate;
import java.util.Collections;

public class PersonUtils {

    private static final String FIRST_NAME = "Zoe";
    private static final String LAST_NAME = "Zuk";
    private static final String CPF_NUMBER = "10369242033";
    private static final long PERSON_ID = 1L;
    public static final LocalDate BIRTH_DATE = LocalDate.of(2003, 10, 12);

    public static PersonDTO createFakeDTO() {
        return PersonDTO.builder()
                .firstName(FIRST_NAME)
                .lastName(LAST_NAME)
                .cpf(CPF_NUMBER)
                .birthDate("2010-04-04")
                .phones(Collections.singletonList(PhoneUtils.createFakeDTO()))
                .build(); // esse builder, build veio da anotacao @builder do lambok
    }

    public static Person createFakeEntity() {
        return Person.builder()
                .id(PERSON_ID)
                .firstName(FIRST_NAME)
                .lastName(LAST_NAME)
                .cpf(CPF_NUMBER)
                .birthDate(BIRTH_DATE)
                .phones(Collections.singletonList(PhoneUtils.createFakeEntity()))
                .build();
    }
}
