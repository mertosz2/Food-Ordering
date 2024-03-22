package com.example.orderservice.service;

import com.example.orderservice.dto.UsersRequest;
import com.example.orderservice.model.Role;
import com.example.orderservice.model.TableKoyama;
import com.example.orderservice.model.Users;
import com.example.orderservice.repository.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UsersService {

    private final TableKoyamaService tableKoyamaService;
    private final UsersRepository usersRepository;
    private final PasswordEncoder encoder;

    public String createUser(UsersRequest request){
        TableKoyama tableKoyama = tableKoyamaService.findTableByTableNumber(request.getTable_number());
        Users users = Users.builder()
                .username(generateUsername())
                .password(encoder.encode(UUID.randomUUID().toString()))
                .tableKoyama(tableKoyama)
                .role(Role.CUSTOMER)
                .num_of_people(request.getNum_of_people())
                .buffet_type(request.getBuffet_type())
                .build();
        usersRepository.save(users);
        return "user created";
    }


    public String generateUsername(){
        LocalDateTime dateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd-HH:mm");
        String formattedDateTime = dateTime.format(formatter);
        return "USER-" + formattedDateTime;
    }

}
