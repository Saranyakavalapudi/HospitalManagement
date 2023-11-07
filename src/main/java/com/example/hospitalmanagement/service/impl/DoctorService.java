package com.example.hospitalmanagement.service.impl;

import com.example.hospitalmanagement.model.Doctor;
import com.example.hospitalmanagement.repository.IDoctorRepository;
import com.example.hospitalmanagement.service.IDoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class DoctorService implements IDoctorService {

    @Autowired
    private IDoctorRepository doctorRepository;


    @Override
    public Doctor addDoctor(Doctor doctor) {
        return doctorRepository.save(doctor);
    }

    @Override
    public List<Doctor> getDoctors() {
        return doctorRepository.findAll();
    }

    @Override
    public Doctor getDoctorById(Long id) {
        return doctorRepository.findById(id).get();
    }

    @Override
    public Doctor updateDoctor(Doctor doctor) {
        return doctorRepository.save(doctor);
    }

    @Override
    public void deleteDoctorById(Long id) {
           doctorRepository.deleteById(id);

    }

    @Override
    public Doctor findByEmailAndPassword(String email, String password) {
        return doctorRepository.findByEmailAndPassword(email,password);
    }
}
