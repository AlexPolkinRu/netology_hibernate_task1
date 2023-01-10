package ru.netology.netology_hibernate_task1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.netology.netology_hibernate_task1.entity.Person;
import ru.netology.netology_hibernate_task1.entity.PersonId;

import java.util.List;
import java.util.Optional;

@Repository
public interface DAORepository extends JpaRepository<Person, PersonId>  {

    List<Person> findByCityOfLiving(String city);

    List<Person> findByAgeLessThanOrderByAge(int age);

    Optional<Person>findByNameAndSurname(String name, String surname);

}
