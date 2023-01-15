package com.it_academy.fitness_secure_version2.dao;

import com.it_academy.fitness_secure_version2.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface RoleRepo extends JpaRepository<Role,Long> {

    Role findByName(String name);
}
