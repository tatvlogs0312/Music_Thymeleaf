package com.example.musicbackend.service.user;

import com.example.musicbackend.entity.User;
import com.example.musicbackend.request.UserRegistrationDto;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    User save(UserRegistrationDto registrationDto);
}
