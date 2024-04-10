package net.javaguides.flightapp.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import net.javaguides.flightapp.entity.admin;

public interface AdminRepository extends JpaRepository<admin, Long> {
    admin findByUsernameIgnoreCase(String username);
}