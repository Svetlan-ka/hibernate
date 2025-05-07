package ru.netology.hibernate.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.netology.hibernate.model.Person;
import ru.netology.hibernate.repository.PersonRepository;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class PersonService {
    private final PersonRepository repository;

    public Person createPerson(Person person) {
        return repository.save(person);
    }

    public Person getPersonById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Person not found"));
    }

    public Person updatePerson(Long id, Person person) {
        Optional<Person> existingPerson = repository.findById(id);
        if (existingPerson.isPresent()) {
            return repository.save(person);
        } else {
            throw new RuntimeException("Person not found");
        }
    }

    public void deletePersonById(Long id) {
        repository.deleteById(id);
    }

    public List<Person> getPersonsByCity(String city) {
        return repository.findByCity(city);
    }

    public List<Person> getPersonsByAgeLessThanOrderByAge(int age) {
        return repository.findByAgeLessThanOrderByAge(age);
    }

    public Optional<Person> getPersonsByFirstNameAndLastName(String firstName, String lastName) {
        return repository.findByFirstNameAndLastName(firstName, lastName);
    }
}
