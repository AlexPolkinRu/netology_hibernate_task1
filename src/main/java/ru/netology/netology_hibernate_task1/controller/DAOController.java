package ru.netology.netology_hibernate_task1.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.netology.netology_hibernate_task1.entity.Person;
import ru.netology.netology_hibernate_task1.service.DAOService;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("/persons")
public class DAOController {

    private final DAOService service;

    @GetMapping("/by-city")
    public List<Person> getPersons(@RequestParam("city") String city) {
        return service.getPersonsByCity(city);
    }

    @GetMapping("/by-age")
    public List<Person> getAge(@RequestParam("age") int age) {
        return service.getAge(age);
    }

    @GetMapping("/name-and-surname")
    public Optional<Person> getNameSurname(@RequestParam String name, @RequestParam String surname) {
        return service.getNameSurname(name, surname);
    }

}
