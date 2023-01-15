package com.it_academy.fitness_secure_version2.api;



import com.it_academy.fitness_secure_version2.api.dto.AuthenticationObject;
import com.it_academy.fitness_secure_version2.dao.UserRepo;
import com.it_academy.fitness_secure_version2.filter.JwtUtil;
import com.it_academy.fitness_secure_version2.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationManager authenticationManager;

    private final UserService userService;

    private final UserRepo userRepo;

    private final JwtUtil jwtUtil;


    @PostMapping("/authenticate")
    public ResponseEntity<String> authenticate(@RequestBody AuthenticationObject authenticationObject) {

        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(authenticationObject.getUsername(), authenticationObject.getPassword()));

        final UserDetails userDetails = userService.loadUserByUsername(authenticationObject.getUsername());

        if (userDetails != null) {
            return ResponseEntity.ok(jwtUtil.generateToken(userDetails));

        }
        return ResponseEntity.status(400).body("Some error has occurred");
    }
}
