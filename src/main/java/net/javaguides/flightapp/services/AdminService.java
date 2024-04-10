package net.javaguides.flightapp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.annotation.PostConstruct;
import net.javaguides.flightapp.entity.admin;
import net.javaguides.flightapp.repository.AdminRepository;

@Service
public class AdminService {
    @Autowired
    private AdminRepository adminRepository;

    @PostConstruct
    public void init() {
        if (adminRepository.findByUsernameIgnoreCase("admin") == null) {
            admin Admin = new admin();
            Admin.setUsername("admin");
            Admin.setPassword("password"); 
            adminRepository.save(Admin);
        }
    }

    
    public int login(String username, String password) {
        admin admin = adminRepository.findByUsernameIgnoreCase(username);
        if (admin != null && admin.getPassword().equals(password)) {
            return 1; // Login successful
        } else {
            return 0; // Unauthorized credentials
        }
    }
}