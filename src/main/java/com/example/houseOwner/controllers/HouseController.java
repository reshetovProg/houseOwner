package com.example.houseOwner.controllers;

import com.example.houseOwner.models.House;
import com.example.houseOwner.models.User;
import com.example.houseOwner.services.HouseService;
import com.example.houseOwner.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.rmi.AccessException;
import java.util.Objects;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/houses")
public class HouseController {
    private final HouseService houseService;
    private final UserService userService;

    @PostMapping
    public ResponseEntity<House> addHouse(@RequestBody House house){

        User user = userService.getUser
                (SecurityContextHolder.getContext().getAuthentication().getName());

        return ResponseEntity.ok(
                houseService.addHouse(House.builder().
                address(house.getAddress()).
                ownerId(user.getId()).build()));

    }

    @PatchMapping
    public ResponseEntity<String> update(@RequestBody House house) throws AccessException {


        User userOwner = userService.getUser(house.getOwnerId());
        House currentHouse = houseService.getHouse(house.getId());
        User user = userService.getUser
                (SecurityContextHolder.getContext().getAuthentication().getName());
        if (user.getId()!= currentHouse.getOwnerId()) throw new AccessException("error access");
        houseService.updateHouse(house);
        return ResponseEntity.ok("change permission");

    }



    @PatchMapping("/{id}")
    public ResponseEntity<String> inviteUser(@RequestBody User user, @PathVariable Long id) {
        var house = houseService.getHouse(id);
        User owner = userService.getUser
                (SecurityContextHolder.getContext().getAuthentication().getName());
        if (!Objects.equals(house.getOwnerId(), owner.getId())) throw new UsernameNotFoundException("house not found");
        var inviteUser = userService.getUser(user.getUsername());
        inviteUser.setHouseId(house.getId());
        userService.updateUser(inviteUser);
        return ResponseEntity.ok("user add");
    }

}
