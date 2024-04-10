package net.javaguides.flightapp.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.javaguides.flightapp.entity.passanger;
import net.javaguides.flightapp.services.PassengerService;

@RestController
@RequestMapping("/api/passengers")
public class PassengerController {

    @Autowired
    private PassengerService passengerService;

    @PostMapping("/create")
    public ResponseEntity<String> createPassenger(@RequestBody passanger passenger) {
        try {
            passanger createdPassenger = passengerService.createPassenger(passenger);
            if (createdPassenger != null) {
                return ResponseEntity.status(HttpStatus.CREATED).body("Passenger created successfully");
            } else {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to create passenger");
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred: " + e.getMessage());
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> updatePassenger(@PathVariable Long id, @RequestBody passanger passenger) {
        Optional<passanger> existingPassenger = passengerService.getPassengerById(id);
        if (existingPassenger.isPresent()) {
            passengerService.updatePassenger(id, passenger);
            return ResponseEntity.status(HttpStatus.OK).body("Passenger updated successfully");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Passenger not found");
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deletePassenger(@PathVariable Long id) {
        Optional<passanger> existingPassenger = passengerService.getPassengerById(id);
        if (existingPassenger.isPresent()) {
            passengerService.deletePassengerById(id);
            return ResponseEntity.status(HttpStatus.OK).body("Passenger deleted successfully");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Passenger not found");
        }
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<?> getPassengerById(@PathVariable Long id) {
        Optional<passanger> passenger = passengerService.getPassengerById(id);
        if (passenger.isPresent()) {
            return ResponseEntity.status(HttpStatus.OK).body(passenger.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Unable to fetch passenger details");
        }
    }
}
