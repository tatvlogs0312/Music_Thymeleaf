package com.example.musicbackend.service.user;

import com.example.musicbackend.entity.User;
import com.example.musicbackend.request.UserRegistrationRequest;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    void save(UserRegistrationRequest registrationDto);

    User findByEmail(String email);
}
