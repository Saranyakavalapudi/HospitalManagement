package com.example.hospitalmanagement.controller;

import com.example.hospitalmanagement.dto.AdminLogin;
import com.example.hospitalmanagement.dto.ChangePassword;
import com.example.hospitalmanagement.model.Patient;
import com.example.hospitalmanagement.service.IDoctorService;
import com.example.hospitalmanagement.service.IPatientService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins="*")
public class AuthController {


    @Autowired
    private IDoctorService doctorService;

    @Autowired
    private IPatientService patientService;

    @PostMapping("/adminlogin")
    private ResponseEntity<?> adminLogin(@RequestBody AdminLogin l)
    {
        try
        {
            if(l.getEmail().equals("admin@gmail.com") && l.getPassword().equals("admin") && l.getMedicalCouncilNumber().equals("25367035"))
            {
                return new ResponseEntity<>(l, HttpStatus.OK);
            }
            return new ResponseEntity<>("invalid credentials",HttpStatus.INTERNAL_SERVER_ERROR);
        }
        catch(Exception e)
        {
                return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @PostMapping("/doctorlogin")
    private ResponseEntity<?> doctorLogin(@RequestBody AdminLogin l)
    {
        try
        {
         if(doctorService.findByEmailAndPassword(l.getEmail(),l.getPassword())!=null)
         {
             return new ResponseEntity<>(l,HttpStatus.OK);
         }
         return new ResponseEntity<>("invalid credentials",HttpStatus.BAD_REQUEST);
        }
        catch(Exception e)
        {
            return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/patientlogin")
    private ResponseEntity<?> patientLogin(@RequestBody AdminLogin l)
    {
        try
        {
            Patient p=patientService.findByEmailAndPassword(l.getEmail(),l.getPassword());
            if(patientService.findByEmailAndPassword(l.getEmail(),l.getPassword())!=null)
            {
                return new ResponseEntity<>(p,HttpStatus.OK);
            }
            return new ResponseEntity<>("Invalid credentials",HttpStatus.BAD_REQUEST);
        }
        catch(Exception e)
        {
            return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/changepassword")
            private ResponseEntity<?> changePassword(@RequestBody ChangePassword newPassword)
    {
            try
            {
                Patient p=patientService.findByEmail(newPassword.getPatientEmail());
                p.setPassword(newPassword.getNewPassword());

                return new ResponseEntity<>(patientService.updatePatient(p),HttpStatus.OK);

            }
            catch(Exception e)
            {
                   return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
            }
    }
}

