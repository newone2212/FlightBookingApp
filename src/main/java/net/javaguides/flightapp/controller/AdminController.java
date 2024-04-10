package net.javaguides.flightapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import net.javaguides.flightapp.services.AdminService;

@RestController
public class AdminController {
    @Autowired
    private AdminService adminService;

    @GetMapping("/admin/login")
    public ResponseEntity<String> login(@RequestParam String username, @RequestParam String password) {
        int result = adminService.login(username, password);
        if (result == 1) {
            return ResponseEntity.status(HttpStatus.CREATED).body("Login successful");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Unauthorized credentials");
        }
    }

    @GetMapping("/admin/logout")
    public ResponseEntity<String> logout() {
        // Perform logout logic here
        // For example, you can invalidate the user's session

        // Return a JSON response with a custom message
        String responseBody = "{\"message\": \"Logout successful\"}";
        return ResponseEntity.status(HttpStatus.OK).body(responseBody);
    }
}