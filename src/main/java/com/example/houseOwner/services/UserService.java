package com.example.houseOwner.services;

import com.example.houseOwner.models.House;
import com.example.houseOwner.models.User;

public interface UserService  {
    User addUser(User user);
    User getUser(Long id);
    User getUser(String username);
    User updateUser(User user);
    void deleteUser(Long id);

}
