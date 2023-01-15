package com.it_academy.fitness_secure_version2.api.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class AuthenticationObject {

    private String username;
    private String password;

}
