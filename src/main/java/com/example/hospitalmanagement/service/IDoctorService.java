package com.example.hospitalmanagement.service;

import com.example.hospitalmanagement.model.Doctor;

import java.util.List;

public interface IDoctorService {

    Doctor addDoctor(Doctor doctor);

    List<Doctor> getDoctors();

    Doctor getDoctorById(Long id);

    Doctor updateDoctor(Doctor doctor);

    void deleteDoctorById(Long id);

    Doctor findByEmailAndPassword(String email,String password);



}



