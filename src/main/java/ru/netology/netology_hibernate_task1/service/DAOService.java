package ru.netology.netology_hibernate_task1.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.netology.netology_hibernate_task1.entity.Person;
import ru.netology.netology_hibernate_task1.repository.DAORepository;

import java.util.List;

@Service
@AllArgsConstructor
public class DAOService {

    private final DAORepository repository;

    public List<Person> getPersonsByCity(String city) {
        return repository.getPersonsByCity(city);
    }

}
