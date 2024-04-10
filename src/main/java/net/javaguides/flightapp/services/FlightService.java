package net.javaguides.flightapp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.javaguides.flightapp.entity.flight;
import net.javaguides.flightapp.repository.FlightsRepository;

@Service
public class FlightService {

    @Autowired
    private FlightsRepository flightsRepository;

    public flight createFlight(flight flight) {
        return flightsRepository.save(flight);
    }

    public flight updateFlight(Long id, flight updatedFlight) {
        Optional<flight> optionalFlight = flightsRepository.findById(id);
        if (optionalFlight.isPresent()) {
            flight existingFlight = optionalFlight.get();
            existingFlight.setComapnyName(updatedFlight.getComapnyName());
            existingFlight.setFlightName(updatedFlight.getFlightName());
            return flightsRepository.save(existingFlight);
        } else {
            // Handle not found scenario
            return null;
        }
    }

    public void deleteFlightById(Long id) {
        flightsRepository.deleteById(id);
    }

    public Optional<flight> getFlightById(Long id) {
        return flightsRepository.findById(id);
    }

    public List<flight> getAllFlights() {
        return flightsRepository.findAll();
    }
}
