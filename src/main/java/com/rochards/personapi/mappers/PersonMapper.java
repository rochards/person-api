package com.rochards.personapi.mappers;

import com.rochards.personapi.dto.request.PersonDTO;
import com.rochards.personapi.entities.Person;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PersonMapper {

    PersonMapper INSTANCE = Mappers.getMapper(PersonMapper.class);

    /* Essa instrucao de formato de datas esta descrita aqui em Person ele eh LocalDate
    * e em PersonDTO ele eh String. */
    @Mapping(target = "birthDate", source = "birthDate", dateFormat = "yyyy-MM-dd")
    Person toModel(PersonDTO personDTO);

    PersonDTO toDTO(Person person);
}
