package net.javaguides.flightapp.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import net.javaguides.flightapp.entity.passanger;
public interface PassangerRepository extends JpaRepository<passanger,Long> {
}