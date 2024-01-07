package com.apitemplate.security.controllers;

import com.apitemplate.security.models.User;
import com.apitemplate.security.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/admin")
public class AdminController {
    @Autowired
    UserRepository userRepository;


    @DeleteMapping(value = "/{username}")
    public ResponseEntity<String> deleteUser(@PathVariable("username") String username) {

        try {
            User user = userRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + username));
            userRepository.delete(user);
            return new ResponseEntity<>("Successfully deleted user", HttpStatus.OK);
        } catch (Exception e) {
            System.out.println("failed to delete user " + e);
        }

        return new ResponseEntity<>("Failed to delete user", HttpStatus.BAD_REQUEST);
    }
}
