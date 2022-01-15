package com.example.fitnessologin.controller;

import com.example.fitnessologin.model.Person;
import com.example.fitnessologin.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/landing")
public class PersonController {
    private final PersonService personService;


    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping("/signup")
    public String signUp(@RequestBody Person person) {
        Person signUpStatus = personService.registerAuth(person.getEmail(), person.getUsername());
        return (signUpStatus == null) ? personService.savePerson(person) +
                "Signed up successfully" : "User already exist, sign in instead";
    }

    @PostMapping("/signin")
    public String signIn(@RequestBody Person person) {
        Person signInStatus = personService.loginAuth(person.getEmail(), person.getUsername());
            return (signInStatus != null) ? signInStatus +
                    "Signed in sucessfully" : "Wrong credentials";
    }



}
