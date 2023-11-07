package com.example.hospitalmanagement.service;

import com.example.hospitalmanagement.model.SlotBooking;

import java.util.List;



public interface ISlotService {

    SlotBooking addService(SlotBooking service);

    List<SlotBooking> getSlotBookings();

    SlotBooking getSlotBookingById(Long id);

    SlotBooking updateSlotBooking(SlotBooking slotBooking);

    void deleteSlotBookingById(Long id);

}
