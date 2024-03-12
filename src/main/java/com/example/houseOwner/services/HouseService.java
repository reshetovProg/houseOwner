package com.example.houseOwner.services;

import com.example.houseOwner.models.House;

import java.util.Optional;

public interface HouseService{

    House addHouse(House house);
    House getHouse(Long id);
    House updateHouse(House house);
    void deleteHouse(Long id);
}
