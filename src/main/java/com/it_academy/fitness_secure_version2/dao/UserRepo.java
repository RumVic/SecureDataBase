package com.it_academy.fitness_secure_version2.dao;


import com.it_academy.fitness_secure_version2.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepo extends JpaRepository<User,Long> {
    User findByUsername(String username);

}
