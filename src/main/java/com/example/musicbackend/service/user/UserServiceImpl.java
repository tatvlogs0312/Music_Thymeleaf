package com.example.musicbackend.service.user;

import com.example.musicbackend.constants.Constants;
import com.example.musicbackend.dto.UserDTO;
import com.example.musicbackend.entity.Role;
import com.example.musicbackend.entity.User;
import com.example.musicbackend.repository.user.UserRepository;
import com.example.musicbackend.request.UserRegistrationDto;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService{

    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository) {
        super();
        this.userRepository = userRepository;
    }

    @Override
    public User save(UserRegistrationDto registrationDto) {
        List<String> error = new ArrayList<>();
        Optional<User> emailExist = userRepository.findByEmail(registrationDto.getEmail());
        if (emailExist.isPresent()){
            error.add("Email đã tồn tại");
            return null;
        }
        User user = new User(registrationDto.getFirstName(),
                registrationDto.getLastName(), registrationDto.getEmail(),
                passwordEncoder.encode(registrationDto.getPassword()), Arrays.asList(new Role(Constants.ROLE_USER)));

        return userRepository.save(user);
    }

    @Override
    public UserDTO me(String email) {
        Optional<User> userOptional = userRepository.findByEmail(email);
        if (userOptional.isPresent()){
            User user = userOptional.get();
            return new UserDTO(user.getLastName(), user.getEmail());
        }
        return null;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Optional<User> userOptional = userRepository.findByEmail(username);
        if(!userOptional.isPresent()) {
            throw new UsernameNotFoundException("Invalid username or password.");
        }
        User user = userOptional.get();
        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), mapRolesToAuthorities(user.getRoles()));
    }

    private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles){
        return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
    }
}
