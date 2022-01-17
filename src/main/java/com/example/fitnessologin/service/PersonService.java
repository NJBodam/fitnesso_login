package com.example.fitnessologin.service;

import com.example.fitnessologin.model.Person;

public interface PersonService {
    Person registerAuth(String email, String password);

    Person savePerson(Person person);

    Person loginAuth(String username, String password);
}
