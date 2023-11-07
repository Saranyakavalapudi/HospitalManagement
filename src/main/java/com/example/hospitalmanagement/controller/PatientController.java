package com.example.hospitalmanagement.controller;


import com.example.hospitalmanagement.model.Patient;
import com.example.hospitalmanagement.service.IPatientService;
import org.apache.coyote.Response;
import org.apache.tomcat.util.http.parser.HttpParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins="*")
public class PatientController {

    @Autowired
    private IPatientService patientService;


    //ENDPOINT FOR ADDING THE PATIENT
    @PostMapping("/patient")
    private ResponseEntity<?> addPatient(@RequestBody Patient patient)
    {
        try
        {
            return new ResponseEntity<>(patientService.addPatient(patient),HttpStatus.OK);
        }
        catch(Exception e)
        {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    //ENDPOINT FOR GETTING THE PATIENT
    @GetMapping("/patient")
    private ResponseEntity<?> getPatients()
    {
        try
        {
              return new ResponseEntity<>(patientService.getPatients(),HttpStatus.OK);
        }
        catch(Exception e)
        {
            return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    //ENDPOINT FOR GETTING THE PATIENT BY ID
    @GetMapping("/patient/{id}")
    private ResponseEntity<?> getPatientById(@PathVariable Long id)
    {
        try
        {
            return new ResponseEntity<>(patientService.getPatientById(id),HttpStatus.OK);
        }
        catch(Exception e)
        {
            return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    //ENDPOINT FOR UPDATING THE PATIENT
    @PutMapping("/patient")
    private ResponseEntity<?> updatePatient(@RequestBody Patient patient)
    {
        try
        {
            return new ResponseEntity<>(patientService.updatePatient(patient),HttpStatus.OK);
        }
        catch(Exception e)
        {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //ENDPOINT FOR DELETING THE PATIENT
    @DeleteMapping("/patient")
    private ResponseEntity<?> deletePatientById(@PathVariable Long id)
    {
        try
        {
            patientService.deletePatientById(id);
             return new ResponseEntity<>("deleted successfully",HttpStatus.OK);
        }
        catch(Exception e)
        {
            return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
