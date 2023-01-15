package com.it_academy.fitness_secure_version2.service;



import com.it_academy.fitness_secure_version2.domain.User;
import org.springframework.security.core.userdetails.UserDetails;


public interface UserService {

    /*User saveUser(User user);*/

    UserDetails loadUserByUsername(String username);

    /*
    Role saveRole(Role role);

    void addRoleToUser(String username,String roleName);

    User getUser(String userName);

    List<User> getUsers();*/

}
