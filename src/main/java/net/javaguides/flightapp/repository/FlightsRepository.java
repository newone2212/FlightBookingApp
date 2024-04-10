package net.javaguides.flightapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.javaguides.flightapp.entity.flight;
public interface FlightsRepository extends JpaRepository<flight, Long> {
    
}