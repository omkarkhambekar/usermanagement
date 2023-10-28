package dev.omkar.usermanagement.service;

import dev.omkar.usermanagement.dto.UserRegistrationRequest;

public interface UserService {
    void registerUser(UserRegistrationRequest registrationRequest);
}
