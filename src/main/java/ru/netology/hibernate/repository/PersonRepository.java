package ru.netology.hibernate.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.springframework.stereotype.Repository;
import ru.netology.hibernate.model.Person;

import java.util.List;

@Repository
public class PersonRepository {
    @PersistenceContext
    private EntityManager entityManager;

    public PersonRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }


    public List<Person> getPersonByCity(String city) {
        Query query = entityManager.createQuery("select p from Person p where city_of_living = :city");
        query.setParameter("city", city);
        return query.getResultList();
    }
}
