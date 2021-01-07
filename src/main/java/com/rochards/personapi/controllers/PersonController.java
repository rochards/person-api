package com.rochards.personapi.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/people") // caminho principal da API
public class PersonController {

    @GetMapping
    public String getAll() {
        return "API works!";
    }
}
