package com.example.cloudsoftspringboot.service;

import com.example.cloudsoftspringboot.model.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();
    User getUserById(Long id);
    void createUser(User user);
    void updateUser(Long id, User user);
    void deleteUser(Long id);
    void deleteUser(User user);
}
