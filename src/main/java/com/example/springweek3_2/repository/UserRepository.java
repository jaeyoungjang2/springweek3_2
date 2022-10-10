package com.example.springweek3_2.repository;

import com.example.springweek3_2.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
}