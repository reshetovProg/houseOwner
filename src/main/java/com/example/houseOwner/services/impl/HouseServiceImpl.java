package com.example.houseOwner.services.impl;

import com.example.houseOwner.models.House;
import com.example.houseOwner.models.User;
import com.example.houseOwner.repositories.HouseRepository;
import com.example.houseOwner.services.HouseService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class HouseServiceImpl implements HouseService {
    private final HouseRepository repository;
    @Override
    public House addHouse(House house) {

        return repository.save(house);
    }
    @Override
    public House getHouse(Long id) {
        return repository.findById(id).orElseThrow(()->new RuntimeException("house not found") );
    }
    @Override
    public House updateHouse(House house) {
        return repository.save(house);
    }
    @Override
    public void deleteHouse(Long id) {
        repository.deleteById(id);
    }


}
