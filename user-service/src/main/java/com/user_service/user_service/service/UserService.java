package com.user_service.user_service.service;

import com.user_service.user_service.model.User;
import com.user_service.user_service.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public List<User> getAllUsers() {
        return repository.findAll();
    }

    public User registerUser(User user) {
        return repository.save(user);
    }

    public User getUserByEmail(String email) {
        return repository.findByEmail(email);
    }
}
