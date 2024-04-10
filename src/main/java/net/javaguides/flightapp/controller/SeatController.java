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

import net.javaguides.flightapp.entity.seat;
import net.javaguides.flightapp.services.SeatService;

@RestController
@RequestMapping("/api/seats")
public class SeatController {

    @Autowired
    private SeatService seatService;

    @PostMapping("/create")
    public ResponseEntity<String> createSeat(@RequestBody seat seat) {
        try {
            seat createdSeat = seatService.createSeat(seat);
            if (createdSeat != null) {
                return ResponseEntity.status(HttpStatus.CREATED).body("Seat created successfully");
            } else {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to create seat");
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred: " + e.getMessage());
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateSeat(@PathVariable Long id, @RequestBody seat seat) {
        Optional<seat> existingSeat = seatService.getSeatById(id);
        if (existingSeat.isPresent()) { // Ensure the correct ID is set
            seatService.updateSeat(id, seat);
            return ResponseEntity.status(HttpStatus.OK).body("Seat updated successfully");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Seat not found");
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteSeat(@PathVariable Long id) {
        Optional<seat> existingSeat = seatService.getSeatById(id);
        if (existingSeat.isPresent()) {
            seatService.deleteSeatById(id);
            return ResponseEntity.status(HttpStatus.OK).body("Seat deleted successfully");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Seat not found");
        }
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<?> getSeatById(@PathVariable Long id) {
        Optional<seat> seat = seatService.getSeatById(id);
        if (seat.isPresent()) {
            return ResponseEntity.status(HttpStatus.OK).body(seat.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Unable to fetch seat details");
        }
    }

}
