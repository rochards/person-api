package com.rochards.personapi.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.List;

/*
* Essas classes de DTO serve para validar os dados de entrada antes mesmo de
* chegar nos models/entidades
* */

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PersonDTO {

    private Long id;

    @NotBlank @Size(min = 2, max = 100)
    private String firstName;

    @NotBlank @Size(min = 2, max = 100)
    private String lastName;

    @NotBlank @CPF // o CPF vem do hibernate validator
    private String cpf;

    private String birthDate;

    @NotEmpty @Valid // o @valid vai dizer para validar os campos de telefone
    private List<PhoneDTO> phones;
}
