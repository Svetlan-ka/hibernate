package ru.netology.hibernate.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "persons")
@IdClass(PersonId.class)
public class Person {
    @Id
    @Column(name = "first_name", nullable = false)
    private String firstName;
    @Id
    @Column(name = "last_name", nullable = false)
    private String lastName;
    @Id
    @Column(name = "age", nullable = false)
    private int age;
    @Column(name = "phone_number", nullable = false)
    private String phoneNumber;
    @Column(name = "city_of_living", nullable = false)
    private String city;
}
