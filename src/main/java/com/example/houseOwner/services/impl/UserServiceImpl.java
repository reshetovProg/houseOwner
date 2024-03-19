package com.example.houseOwner.services.impl;

import com.example.houseOwner.models.User;
import com.example.houseOwner.repositories.UserRepository;
import com.example.houseOwner.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService, UserDetailsService {
    private final UserRepository repository;
    @Override
    public User addUser(User house) {
        return repository.save(house);
    }
    @Override
    public User getUser(Long id) {
        return repository.findById(id).orElseThrow(()->new UsernameNotFoundException("user not found") );
    }

    @Override
    public User getUser(String username) {
        return repository.findByName(username).orElseThrow(()->new UsernameNotFoundException("user not found") );
    }

    @Override
    public User updateUser(User house) {
        return repository.save(house);
    }
    @Override
    public void deleteUser(Long id) {
        repository.deleteById(id);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return repository.findByName(username)
                .orElseThrow(()->new UsernameNotFoundException("user not found"));
    }
}
