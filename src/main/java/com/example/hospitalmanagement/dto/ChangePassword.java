package com.example.hospitalmanagement.dto;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ChangePassword {

    private String patientEmail;

    private String newPassword;

}
