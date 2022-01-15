package com.example.fitnessologin.controller;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;

import com.example.fitnessologin.model.Address;
import com.example.fitnessologin.model.Person;
import com.example.fitnessologin.model.Role;
import com.example.fitnessologin.service.PersonService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ContextConfiguration(classes = {PersonController.class})
@ExtendWith(SpringExtension.class)
class PersonControllerTest {
    @Autowired
    private PersonController personController;

    @MockBean
    private PersonService personService;

    @Test
    void testSignIn() throws Exception {
        Person person = new Person();
        person.setAddress(new Address());
        person.setEmail("jane.doe@example.org");
        person.setFirstname("Jane");
        person.setId(123L);
        person.setLastname("Doe");
        person.setPassword("iloveyou");
        person.setPhone(1);
        person.setRole(Role.PREMIUM);
        person.setUsername("janedoe");

        Address address = new Address();
        address.setCity("Oxford");
        address.setCountry("GB");
        address.setId(123L);
        address.setPerson(person);
        address.setStreetAddress("42 Main St");
        address.setZipCode(1);

        Person person1 = new Person();
        person1.setAddress(address);
        person1.setEmail("jane.doe@example.org");
        person1.setFirstname("Jane");
        person1.setId(123L);
        person1.setLastname("Doe");
        person1.setPassword("iloveyou");
        person1.setPhone(1);
        person1.setRole(Role.PREMIUM);
        person1.setUsername("janedoe");

        Address address1 = new Address();
        address1.setCity("Oxford");
        address1.setCountry("GB");
        address1.setId(123L);
        address1.setPerson(person1);
        address1.setStreetAddress("42 Main St");
        address1.setZipCode(1);

        Person person2 = new Person();
        person2.setAddress(address1);
        person2.setEmail("jane.doe@example.org");
        person2.setFirstname("Jane");
        person2.setId(123L);
        person2.setLastname("Doe");
        person2.setPassword("iloveyou");
        person2.setPhone(1);
        person2.setRole(Role.PREMIUM);
        person2.setUsername("janedoe");
        when(this.personService.loginAuth((String) any(), (String) any())).thenReturn(person2);

        Person person3 = new Person();
        person3.setAddress(new Address());
        person3.setEmail("jane.doe@example.org");
        person3.setFirstname("Jane");
        person3.setId(123L);
        person3.setLastname("Doe");
        person3.setPassword("iloveyou");
        person3.setPhone(1);
        person3.setRole(Role.PREMIUM);
        person3.setUsername("janedoe");

        Address address2 = new Address();
        address2.setCity("Oxford");
        address2.setCountry("GB");
        address2.setId(123L);
        address2.setPerson(person3);
        address2.setStreetAddress("42 Main St");
        address2.setZipCode(1);

        Person person4 = new Person();
        person4.setAddress(address2);
        person4.setEmail("jane.doe@example.org");
        person4.setFirstname("Jane");
        person4.setId(123L);
        person4.setLastname("Doe");
        person4.setPassword("iloveyou");
        person4.setPhone(1);
        person4.setRole(Role.PREMIUM);
        person4.setUsername("janedoe");

        Address address3 = new Address();
        address3.setCity("Oxford");
        address3.setCountry("GB");
        address3.setId(123L);
        address3.setPerson(person4);
        address3.setStreetAddress("42 Main St");
        address3.setZipCode(1);

        Person person5 = new Person();
        person5.setAddress(address3);
        person5.setEmail("jane.doe@example.org");
        person5.setFirstname("Jane");
        person5.setId(123L);
        person5.setLastname("Doe");
        person5.setPassword("iloveyou");
        person5.setPhone(1);
        person5.setRole(Role.PREMIUM);
        person5.setUsername("janedoe");
        String content = (new ObjectMapper()).writeValueAsString(person5);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/landing/signin")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        MockMvcBuilders.standaloneSetup(this.personController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("text/plain;charset=ISO-8859-1"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "Person(id=123, firstname=Jane, lastname=Doe, email=jane.doe@example.org, password=iloveyou, phone=1,"
                                        + " address=Address(id=123, streetAddress=42 Main St, city=Oxford, zipCode=1, country=GB, person=Person(id=123,"
                                        + " firstname=Jane, lastname=Doe, email=jane.doe@example.org, password=iloveyou, phone=1, address=Address"
                                        + "(id=123, streetAddress=42 Main St, city=Oxford, zipCode=1, country=GB, person=Person(id=123,"
                                        + " firstname=Jane, lastname=Doe, email=jane.doe@example.org, password=iloveyou, phone=1, address=Address"
                                        + "(id=null, streetAddress=null, city=null, zipCode=0, country=null, person=null), role=PREMIUM,"
                                        + " username=janedoe)), role=PREMIUM, username=janedoe)), role=PREMIUM, username=janedoe)Signed in"
                                        + " sucessfully"));
    }

    @Test
    void testSignUp() throws Exception {
        Person person = new Person();
        person.setAddress(new Address());
        person.setEmail("jane.doe@example.org");
        person.setFirstname("Jane");
        person.setId(123L);
        person.setLastname("Doe");
        person.setPassword("iloveyou");
        person.setPhone(1);
        person.setRole(Role.PREMIUM);
        person.setUsername("janedoe");

        Address address = new Address();
        address.setCity("Oxford");
        address.setCountry("GB");
        address.setId(123L);
        address.setPerson(person);
        address.setStreetAddress("42 Main St");
        address.setZipCode(1);

        Person person1 = new Person();
        person1.setAddress(address);
        person1.setEmail("jane.doe@example.org");
        person1.setFirstname("Jane");
        person1.setId(123L);
        person1.setLastname("Doe");
        person1.setPassword("iloveyou");
        person1.setPhone(1);
        person1.setRole(Role.PREMIUM);
        person1.setUsername("janedoe");

        Address address1 = new Address();
        address1.setCity("Oxford");
        address1.setCountry("GB");
        address1.setId(123L);
        address1.setPerson(person1);
        address1.setStreetAddress("42 Main St");
        address1.setZipCode(1);

        Person person2 = new Person();
        person2.setAddress(address1);
        person2.setEmail("jane.doe@example.org");
        person2.setFirstname("Jane");
        person2.setId(123L);
        person2.setLastname("Doe");
        person2.setPassword("iloveyou");
        person2.setPhone(1);
        person2.setRole(Role.PREMIUM);
        person2.setUsername("janedoe");
        when(this.personService.registerAuth((String) any(), (String) any())).thenReturn(person2);

        Person person3 = new Person();
        person3.setAddress(new Address());
        person3.setEmail("jane.doe@example.org");
        person3.setFirstname("Jane");
        person3.setId(123L);
        person3.setLastname("Doe");
        person3.setPassword("iloveyou");
        person3.setPhone(1);
        person3.setRole(Role.PREMIUM);
        person3.setUsername("janedoe");

        Address address2 = new Address();
        address2.setCity("Oxford");
        address2.setCountry("GB");
        address2.setId(123L);
        address2.setPerson(person3);
        address2.setStreetAddress("42 Main St");
        address2.setZipCode(1);

        Person person4 = new Person();
        person4.setAddress(address2);
        person4.setEmail("jane.doe@example.org");
        person4.setFirstname("Jane");
        person4.setId(123L);
        person4.setLastname("Doe");
        person4.setPassword("iloveyou");
        person4.setPhone(1);
        person4.setRole(Role.PREMIUM);
        person4.setUsername("janedoe");

        Address address3 = new Address();
        address3.setCity("Oxford");
        address3.setCountry("GB");
        address3.setId(123L);
        address3.setPerson(person4);
        address3.setStreetAddress("42 Main St");
        address3.setZipCode(1);

        Person person5 = new Person();
        person5.setAddress(address3);
        person5.setEmail("jane.doe@example.org");
        person5.setFirstname("Jane");
        person5.setId(123L);
        person5.setLastname("Doe");
        person5.setPassword("iloveyou");
        person5.setPhone(1);
        person5.setRole(Role.PREMIUM);
        person5.setUsername("janedoe");
        String content = (new ObjectMapper()).writeValueAsString(person5);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/landing/signup")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        MockMvcBuilders.standaloneSetup(this.personController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("text/plain;charset=ISO-8859-1"))
                .andExpect(MockMvcResultMatchers.content().string("User already exist, sign in instead"));
    }
}

