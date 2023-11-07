package com.example.hospitalmanagement.service.impl;


import com.example.hospitalmanagement.model.Patient;
import com.example.hospitalmanagement.repository.IPatientRepository;
import com.example.hospitalmanagement.service.IPatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService implements IPatientService{

    @Autowired
    private IPatientRepository patientRepository;

    @Override
    public Patient addPatient(Patient patient) {
        return patientRepository.save(patient);
    }

    @Override
    public List<Patient> getPatients() {
        return patientRepository.findAll();
    }

    @Override
    public Patient getPatientById(Long id) {
        return patientRepository.findById(id).get();
    }

    @Override
    public Patient updatePatient(Patient patient) {
        return patientRepository.save(patient);
    }

    @Override
    public void deletePatientById(Long id) {
            patientRepository.deleteById(id);
    }

    @Override
    public Patient findByEmailAndPassword(String email, String password) {
        return patientRepository.findByEmailAndPassword(email,password);
    }

    @Override
    public Patient findByEmail(String email) {
        return patientRepository.findByEmail(email);
    }
}
