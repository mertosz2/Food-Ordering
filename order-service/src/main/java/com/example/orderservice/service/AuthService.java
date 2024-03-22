package com.example.orderservice.service;

import com.example.orderservice.dto.LoginRequest;
import com.example.orderservice.model.Users;
import com.example.orderservice.repository.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final JwtService jwtService;
    private final UsersRepository usersRepository;
    private final AuthenticationManager authenticationManager;

    public String authenticate(LoginRequest request){
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getUsername(),
                        request.getPassword()
                )
        );
        Users users = usersRepository.findByUsername(request.getUsername()).orElseThrow();
        String token = jwtService.generateToken(users);
        return token;
    }
}
