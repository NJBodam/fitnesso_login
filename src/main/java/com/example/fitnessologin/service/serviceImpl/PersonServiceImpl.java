package com.example.fitnessologin.service.serviceImpl;

import com.example.fitnessologin.model.Person;
import com.example.fitnessologin.repository.PersonRepository;
import com.example.fitnessologin.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonServiceImpl implements PersonService {
    PersonRepository personRepository;

    @Autowired
    public PersonServiceImpl(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public Person registerAuth(String email, String password) {
        return personRepository.findFirstByEmailOrUsername(email, password).orElse(null);
    }

    @Override
    public Person savePerson(Person person) {
        return personRepository.save(person);
    }

    @Override
    public Person loginAuth(String email, String password) {
        return personRepository.findByEmailAndPassword(email, password).orElse(null);
    }
}
