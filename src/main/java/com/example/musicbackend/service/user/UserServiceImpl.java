package com.example.musicbackend.service.user;

import com.example.musicbackend.constants.Constants;
import com.example.musicbackend.entity.User;
import com.example.musicbackend.repository.user.RoleRepository;
import com.example.musicbackend.repository.user.UserRepository;
import com.example.musicbackend.request.UserRegistrationRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public void save(UserRegistrationRequest registrationDto) {
        User user = new User();
        user.setEmail(registrationDto.getEmail());
        user.setFirstName(registrationDto.getFirstName());
        user.setLastName(registrationDto.getLastName());
        user.setPassword(bCryptPasswordEncoder.encode(registrationDto.getPassword()));
        user.setRoles(new HashSet<>(roleRepository.findByName(Constants.ROLE_USER)));
        userRepository.save(user);
    }

    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }
}
