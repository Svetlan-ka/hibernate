package ru.netology.hibernate.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.netology.hibernate.model.Person;

import java.util.List;
import java.util.Optional;


@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

    @Query("select p from Person p where p.city = ?1")
    List<Person> findByCity(String city);

    @Query("select p from Person p where p.age < ?1 order by p.age")
    List<Person> findByAgeLessThanOrderByAge(int age);

    @Query("select p from Person p where p.firstName = ?1 and p.lastName = ?2")
    Optional<Person> findByFirstNameAndLastName(String firstName, String lastName);
}
