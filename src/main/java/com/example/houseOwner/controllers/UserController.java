package com.example.houseOwner.controllers;

import com.example.houseOwner.config.AuthenticationResponse;
import com.example.houseOwner.models.House;
import com.example.houseOwner.models.User;
import com.example.houseOwner.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/users")
public class UserController {
    private final UserService service;
//    @PostMapping
//    public ResponseEntity<User> addUser(@RequestBody User user){
//
//    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUser(@PathVariable Long id){
        return ResponseEntity.ok(service.getUser(id));
    }

//    @PutMapping
//    public ResponseEntity<User> updateUser(@RequestBody User user){
//
//    }
//
    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id){
        service.deleteUser(id);
    }




}
