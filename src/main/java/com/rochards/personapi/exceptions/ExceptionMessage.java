package com.rochards.personapi.exceptions;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.OffsetDateTime;
import java.util.List;

@JsonInclude(Include.NON_NULL) // nao vai mostrar nulls
@Data @AllArgsConstructor
public class ExceptionMessage {

    private Integer status;
    private OffsetDateTime timestamp;
    private String title;
    private List<Field> fields;
}

@Data @AllArgsConstructor
class Field {

    private String name;
    private String msg;
}
