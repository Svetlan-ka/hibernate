package ru.netology.hibernate.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.netology.hibernate.model.Person;
import ru.netology.hibernate.service.PersonService;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("/persons")
public class Controller {
    private final PersonService service;

    @PostMapping("/create")
    public Person createPerson(@RequestBody Person person) {
        return service.createPerson(person);
    }

    @GetMapping("/{id}")
    public Person getPersonById(@PathVariable Long id) {
        return service.getPersonById(id);
    }

    @PutMapping("/update/{id}")
    public Person updatePerson(@PathVariable Long id, @RequestBody Person updatedPerson) {
        return service.updatePerson(id, updatedPerson);
    }
    @DeleteMapping("/delete/{id}")
    public void deletePerson(@PathVariable Long id) {
        service.deletePersonById(id);
        System.out.println("Person with ID " + id + " deleted.");
    }

    @GetMapping("/search-by-city")
    public List<Person> getPersonsByCity(@RequestParam String city) {
        return service.getPersonsByCity(city);
    }

    @GetMapping("/search-by-age")
    public List<Person> getPersonsByAgeLessThanOrderByAge(@RequestParam int age) {
        return service.getPersonsByAgeLessThanOrderByAge(age);
    }

    @GetMapping("/search-by-lastname-and-firstname")
    public Optional<Person> getPersonsByFirstNameAndLastName(@RequestParam String firstName, @RequestParam String lastName) {
        return service.getPersonsByFirstNameAndLastName(firstName, lastName);
    }




}
