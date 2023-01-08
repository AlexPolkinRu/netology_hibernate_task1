package ru.netology.netology_hibernate_task1.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.netology.netology_hibernate_task1.entity.Person;
import ru.netology.netology_hibernate_task1.service.DAOService;

import java.util.List;

@RestController
@AllArgsConstructor
public class DAOController {

    private final DAOService service;

    @GetMapping("/persons/by-city")
    public List<Person> getPersons(@RequestParam("city") String city) {
        return service.getPersonsByCity(city);
    }
}
