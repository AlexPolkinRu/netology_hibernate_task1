package ru.netology.netology_hibernate_task1.service;

import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;
import ru.netology.netology_hibernate_task1.entity.Person;
import ru.netology.netology_hibernate_task1.repository.DAORepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.IntStream;

@Service
@AllArgsConstructor
public class DAOService implements CommandLineRunner {

    private final DAORepository repository;

    @Transactional
    public void run (String... args) {
        var names = List.of("Ivan", "Petr", "Maxim", "Alex", "Mike");
        var surnames = List.of("Ivanov", "Petrov", "Koshkin", "Belkin", "Strelkin");
        var cities = List.of("Moscow", "Tula", "Kaluga", "Samara", "Sochi");
        var random = new Random();
        IntStream.range(0,25).
                forEach(i -> {
                    var person = Person.builder()
                            .name(names.get(random.nextInt(names.size())))
                            .surname(surnames.get(random.nextInt(surnames.size())))
                            .age(random.nextInt(92))
                            .phoneNumber(random.nextInt(123456))
                            .cityOfLiving(cities.get(random.nextInt(surnames.size())))
                            .build();

                    repository.save(person);
                });

    }

    public List<Person> getPersonsByCity(String city) {
        return repository.findByCityOfLiving(city);
    }

    public List<Person> getAge(int age) {
        return repository.findByAgeLessThanOrderByAge(age);
    }

    public Optional<Person> getNameSurname(String name, String surname) {
        return repository.findByNameAndSurname(name, surname);
    }

}
