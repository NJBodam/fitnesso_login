package com.example.fitnessologin.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Objects;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String streetAddress;
    private String city;
    private int zipCode;
    private String country;
    @JoinColumn(name = "person_id")
    @OneToOne
    private Person person;


}
