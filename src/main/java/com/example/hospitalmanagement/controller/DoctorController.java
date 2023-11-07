package com.example.hospitalmanagement.controller;

import com.example.hospitalmanagement.model.Doctor;
import com.example.hospitalmanagement.model.Report;
import com.example.hospitalmanagement.service.IDoctorService;
import com.example.hospitalmanagement.service.IReportService;
import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Base64;


@RestController
@CrossOrigin(origins="*")
public class DoctorController {

    @Autowired
    private IDoctorService doctorService;

    @Autowired
    private IReportService reportService;

  //ENDPOINT FOR ADDING THE DOCTOR
    @PostMapping("/doctor")
    private ResponseEntity<?> addDoctor(@RequestBody Doctor doctor)
    {
        try
        {
            return new ResponseEntity<>(doctorService.addDoctor(doctor), HttpStatus.OK);
        }
        catch(Exception e)
        {
            return new ResponseEntity<>(e.getMessage(),HttpStatus.OK);
        }
    }

    //ENDPOINT FOR GETTING THE DOCTOR
    @GetMapping("/doctor")
    private ResponseEntity<?> getDoctors()
    {
        try
        {
            return new ResponseEntity<>(doctorService.getDoctors(),HttpStatus.OK);
        }
        catch(Exception e)
        {
            return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    //ENDPOINT FOR GETTING THE DOCTOR BY ID
    @GetMapping("/doctor/{id}")
    private ResponseEntity<?> getDoctorById(@PathVariable Long id)
    {
        try
        {
            return new ResponseEntity<>(doctorService.getDoctorById(id),HttpStatus.OK);
        }
        catch(Exception e)
        {
            return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    //ENDPOINT FOR UPDATING THE DOCTOR
    @PutMapping("/doctor")
    private ResponseEntity<?> updateDoctor(@RequestBody Doctor doctor)
    {
        try
        {
            return new ResponseEntity<>(doctorService.updateDoctor(doctor),HttpStatus.OK);
        }
        catch(Exception e)
        {
            return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //ENDPOINT FOR DELETING THE DOCTOR BY ID
    @DeleteMapping("/doctor/{id}")
    private ResponseEntity<?>  deleteDoctorById(@PathVariable Long id)
    {
        try
        {
            doctorService.deleteDoctorById(id);
            return new ResponseEntity<>("deleted successfully",HttpStatus.OK);
        }
        catch(Exception e)
        {
            return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    //ENDPOINT FOR UPLOADING THE REPORT
    @PostMapping("/uploadreport")
    private ResponseEntity<?> uploadReport(@RequestParam("report") MultipartFile file)
    {

//        String filePath=Paths.get("").toAbsolutePath().toString();
//        Path actualFilePath=Paths.get(filePath,"src","main","resources","static","reports",file.getOriginalFilename());

        System.out.println(file);
        try
        {
//             file.transferTo(actualFilePath);
             Report report=Report.builder()
                     .file(Base64.getEncoder().encodeToString(file.getBytes()))
                     .build();

            return new ResponseEntity<>(reportService.addReport(report),HttpStatus.OK);
        }

        catch(Exception e)
        {
             return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
