package com.example.hospitalmanagement.controller;


import com.example.hospitalmanagement.model.Patient;
import com.example.hospitalmanagement.model.Report;
import com.example.hospitalmanagement.service.IPatientService;
import com.example.hospitalmanagement.service.IReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Base64;

@RestController
@CrossOrigin(origins = "*")
public class ReportController {

    @Autowired
    private IPatientService patientService;

    @Autowired
    private IReportService reportService;


         @PostMapping("/report/{id}")
         private ResponseEntity<?> addReport(@PathVariable Long id, @RequestParam("report")MultipartFile file)
         {
             try
             {
                  Patient p=patientService.getPatientById(id);
                  p.setChecked(true);
                  Report report= Report.builder()
                          .file(Base64.getEncoder().encodeToString(file.getBytes()))
                          .build();
                  p.getReports().add(report);
                  return new ResponseEntity<>(patientService.updatePatient(p), HttpStatus.OK);
             }
             catch(Exception e)
             {

                   return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
             }
         }

         @GetMapping("/report")
         private ResponseEntity<?> getReports()
         {
            try
            {
                return new ResponseEntity<>(reportService.getReports(),HttpStatus.OK);
            }
            catch(Exception e)
            {
                return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
            }
         }

         @GetMapping("/report/{id}")
         private ResponseEntity<?> getReportById(@PathVariable long id)
         {
             try
             {
                 return new ResponseEntity<>(reportService.getReportById(id),HttpStatus.OK);
             }
             catch(Exception e)
             {
                 return  new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
             }
         }
         @PutMapping("/report")
         private ResponseEntity<?>  updateReport(@RequestBody Report report)
         {
             try
             {
                 return new ResponseEntity<>(reportService.updateReport(report),HttpStatus.OK);
             }
             catch(Exception e)
             {
                 return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
             }
         }

         @DeleteMapping("/report/{id}")
         private ResponseEntity<?> deleteReport(@PathVariable Long id)
         {
             try
             {
                 reportService.deleteReport(id);
                 return new ResponseEntity<>("deleted successfully",HttpStatus.OK);
             }
             catch(Exception e)
             {
                 return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
             }
         }


    @GetMapping("/reportdecrypt/{id}")
    private ResponseEntity<?> addReport(@PathVariable Long id)
    {
        try
        {
            Patient p=patientService.getPatientById(id);
            String file=p.getReports().get(0).getFile();
            byte[] decryptedReport= Base64.getDecoder().decode(file);
            return new ResponseEntity<>(decryptedReport, HttpStatus.OK);
        }
        catch(Exception e)
        {

            return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }




}

