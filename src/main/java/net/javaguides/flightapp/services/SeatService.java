package net.javaguides.flightapp.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.javaguides.flightapp.entity.seat;
import net.javaguides.flightapp.repository.SeatRepository;

@Service
public class SeatService {

    @Autowired
    private SeatRepository seatRepository;

    public seat createSeat(seat seat) {
        return seatRepository.save(seat);
    }

    public Optional<seat> getSeatById(Long id) {
        return seatRepository.findById(id);
    }

    public seat updateSeat(Long id, seat updatedFlight) {
        Optional<seat> optionalseats = seatRepository.findById(id);
        if (optionalseats.isPresent()) {
            seat existingSeat = optionalseats.get();
            existingSeat.setFlightNo(updatedFlight.getFlightNo());
            existingSeat.setSeatNo(updatedFlight.getSeatNo());
            return seatRepository.save(existingSeat);
        } else {
            // Handle not found scenario
            return null;
        }
    }

    public void deleteSeatById(Long id) {
        seatRepository.deleteById(id);
    }

    // You can add more methods here as per your business requirements

}
