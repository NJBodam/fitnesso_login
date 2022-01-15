package com.example.fitnessologin.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import javax.transaction.Transactional;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String firstname;
    private String lastname;
    private String email;
    private String password;
    private int phone;
    @OneToOne
    private Address address;
    private Role role;
    private String username;

}
