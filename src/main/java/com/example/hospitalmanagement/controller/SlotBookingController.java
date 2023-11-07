package com.example.hospitalmanagement.controller;

import com.example.hospitalmanagement.model.SlotBooking;
import com.example.hospitalmanagement.service.ISlotService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins="*")
public class SlotBookingController {

    @Autowired
    private ISlotService slotService;


    //ENDPOINT FOR ADDING THE SLOT BOOKING
    @PostMapping("/slotbooking")
    private ResponseEntity<?> addSlotBooking(@RequestBody SlotBooking slotBooking) {
        try {
            return new ResponseEntity<>(slotService.addService(slotBooking), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.OK);
        }
    }


    //ENDPOINT FOR GETTING ALL THE BOOKED SLOTS
    @GetMapping("/slotbooking")
    private ResponseEntity<?> getSlotBookings() {
        try {
            return new ResponseEntity<>(slotService.getSlotBookings(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.OK);
        }
    }


    //ENDPOINT FOR GETTING THE SLOT BOOKING BY ID
    @GetMapping("/slotbooking/{id}")
    private ResponseEntity<?> getSlotBookingById(Long id) {
        try {
              return new ResponseEntity<>(slotService.getSlotBookingById(id),HttpStatus.OK);
        }
        catch (Exception e)
        {
           return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //ENDPOINT FOR UPDATING THE SLOT BOOKING
    @PutMapping("/slotbooking")
    private ResponseEntity<?>  updateSlotBooking(@RequestBody SlotBooking slotBooking)
    {
        try
        {
            return new ResponseEntity<>(slotService.updateSlotBooking(slotBooking), HttpStatus.OK);
        }
        catch(Exception e)
        {
            return new ResponseEntity<>(e.getMessage(),HttpStatus.OK);
        }
    }


    //ENDPOINT FOR DELETING THE SLOT BOOKING
    @DeleteMapping("/slotbooking")
    private ResponseEntity<?> deleteSlotBookingById(@PathVariable Long id)
    {
        try
        {
            slotService.deleteSlotBookingById(id);
            return new ResponseEntity<>("deleted successfully",HttpStatus.OK);
        }
        catch(Exception e)
        {
            return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
