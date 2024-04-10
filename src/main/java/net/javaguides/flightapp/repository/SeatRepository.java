package net.javaguides.flightapp.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import net.javaguides.flightapp.entity.seat;
public interface SeatRepository extends JpaRepository<seat,Long>{
    
}