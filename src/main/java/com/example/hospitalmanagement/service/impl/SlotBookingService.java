package com.example.hospitalmanagement.service.impl;


import com.example.hospitalmanagement.model.SlotBooking;
import com.example.hospitalmanagement.repository.ISlotBookingRepository;
import com.example.hospitalmanagement.service.ISlotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SlotBookingService implements ISlotService {

    @Autowired
    private ISlotBookingRepository slotBookingRepository;

    @Override
    public SlotBooking addService(SlotBooking slotBooking) {
        return slotBookingRepository.save(slotBooking);
    }

    @Override
    public List<SlotBooking> getSlotBookings() {
        return slotBookingRepository.findAll();
    }

    @Override
    public SlotBooking getSlotBookingById(Long id) {
        return slotBookingRepository.findById(id).get();
    }

    @Override
    public SlotBooking updateSlotBooking(SlotBooking slotBooking) {
        return slotBookingRepository.save(slotBooking);
    }

    @Override
    public void deleteSlotBookingById(Long id) {
            slotBookingRepository.deleteById(id);
    }
}
