package net.javaguides.flightapp.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.javaguides.flightapp.entity.passanger;
import net.javaguides.flightapp.repository.PassangerRepository;

@Service
public class PassengerService {

    @Autowired
    private PassangerRepository passengerRepository;

    public passanger createPassenger(passanger passenger) {
        return passengerRepository.save(passenger);
    }

    public Optional<passanger> getPassengerById(Long id) {
        return passengerRepository.findById(id);
    }

    public passanger updatePassenger(Long id, passanger updatedFlight) {
        Optional<passanger> optionalseats = passengerRepository.findById(id);
        if (optionalseats.isPresent()) {
            passanger existingSeat = optionalseats.get();
            existingSeat.setIdentityInformation(updatedFlight.getIdentityInformation());
            existingSeat.setIdentityType(updatedFlight.getIdentityType());
            existingSeat.setName(updatedFlight.getName());
            existingSeat.setRemarks(updatedFlight.getRemarks());
            return passengerRepository.save(existingSeat);
        } else {
            // Handle not found scenario
            return null;
        }
    }

    public void deletePassengerById(Long id) {
        passengerRepository.deleteById(id);
    }

}
