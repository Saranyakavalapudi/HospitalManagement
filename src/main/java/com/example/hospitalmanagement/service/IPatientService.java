package com.example.hospitalmanagement.service;


import com.example.hospitalmanagement.model.Patient;

import java.util.List;

public interface IPatientService {

    Patient addPatient(Patient patient);

    List<Patient> getPatients();

    Patient getPatientById(Long id);

    Patient updatePatient(Patient patient);

    void deletePatientById(Long id);

    Patient findByEmailAndPassword(String email,String password);

    Patient findByEmail(String email);


}
