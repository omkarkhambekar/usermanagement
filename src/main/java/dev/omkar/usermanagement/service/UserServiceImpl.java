package dev.omkar.usermanagement.service;

import dev.omkar.usermanagement.Entity.User;
import dev.omkar.usermanagement.dto.UserRegistrationRequest;
import dev.omkar.usermanagement.exception.UserAlreadyExistsException;
import dev.omkar.usermanagement.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;


    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;

    }

    @Override
    public void registerUser(UserRegistrationRequest registrationRequest) {
        if (userRepository.findByUsername(registrationRequest.getUsername()) != null) {
            throw new UserAlreadyExistsException("Username already exists.");
        }
        if (userRepository.findByEmail(registrationRequest.getEmail()) != null) {
            throw new UserAlreadyExistsException("Email address is already registered.");
        }

        User newUser = new User();
        newUser.setUsername(registrationRequest.getUsername());
        newUser.setEmail(registrationRequest.getEmail());
        newUser.setPassword(registrationRequest.getPassword());

        userRepository.save(newUser);
    }
}
