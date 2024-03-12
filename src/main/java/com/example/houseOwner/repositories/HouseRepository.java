package com.example.houseOwner.repositories;

import com.example.houseOwner.models.House;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HouseRepository extends JpaRepository<House, Long> {
}
