package com.example.hospitalmanagement.dto;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AdminLogin {

    private String email;

    private String password;

    private String medicalCouncilNumber;

    private String doctorLicenseNumber;

    private String aadharNumber;
}
