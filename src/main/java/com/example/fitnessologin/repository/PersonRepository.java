package com.example.fitnessologin.repository;

import com.example.fitnessologin.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PersonRepository extends JpaRepository<Person, Long> {
    Optional<Person> findFirstByEmailOrUsername(String email, String username);

    Optional<Person> findByEmailAndPassword(String email, String password);
}
