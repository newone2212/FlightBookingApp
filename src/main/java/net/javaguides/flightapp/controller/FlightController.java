package net.javaguides.flightapp.controller;

// import java.util.List;
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

import net.javaguides.flightapp.entity.flight;
import net.javaguides.flightapp.services.FlightService;

@RestController
@RequestMapping("/api/flights")
public class FlightController {

    @Autowired
    private FlightService flightService;

    @PostMapping("/create")
    public ResponseEntity<String> createFlight(@RequestBody flight flight) {
        try {
            flight createdFlight = flightService.createFlight(flight);
            if (createdFlight != null) {
                return ResponseEntity.status(HttpStatus.CREATED).body("Flight created successfully");
            } else {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to create flight");
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred: " + e.getMessage());
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateflight(@PathVariable Long id, @RequestBody flight flight) {
        Optional<flight> existingFlight = flightService.getFlightById(id);
        if (existingFlight.isPresent()) { // Ensure the correct ID is set
            flightService.updateFlight(id,flight);
            return ResponseEntity.status(HttpStatus.OK).body("Flight updated successfully");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Flight not found");
        }
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteFlight(@PathVariable Long id) {
        Optional<flight> existingFlight = flightService.getFlightById(id);
        if (existingFlight.isPresent()) {
            flightService.deleteFlightById(id);
            return ResponseEntity.status(HttpStatus.OK).body("Flight deleted successfully");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Flight not found");
        }
    }
    @GetMapping("/get/{id}")
    public ResponseEntity<?> getFlightById(@PathVariable Long id) {
        Optional<flight> flight = flightService.getFlightById(id);
        if (flight.isPresent()) {
            return ResponseEntity.status(HttpStatus.OK).body(flight.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Unable to fetch flight details");
        }
    }

}
