package com.example.cloudsoftspringboot.repository;

import com.example.cloudsoftspringboot.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    public List<User> findAllByOrderByIdAsc();
}
