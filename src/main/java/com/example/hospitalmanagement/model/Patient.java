package com.example.hospitalmanagement.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Patient {


    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String name;

    private String email;

    private String password;

    private LocalDate dateOfBirth;

    private String mobile;

    private String gender;
    private String address;
    private boolean isChecked=false;


    @OneToMany(cascade = CascadeType.ALL)
    private List<Report> reports;

    private String aadharNumber;


}
