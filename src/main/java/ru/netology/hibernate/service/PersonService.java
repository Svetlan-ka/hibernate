package ru.netology.hibernate.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.netology.hibernate.model.Person;
import ru.netology.hibernate.repository.PersonRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class PersonService {
    private final PersonRepository repository;

    public List<Person> getPersonsByCity(String city) {
        return repository.getPersonByCity(city);
    }

}
