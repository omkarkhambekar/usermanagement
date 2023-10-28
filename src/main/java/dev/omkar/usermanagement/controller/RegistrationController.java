package dev.omkar.usermanagement.controller;

import dev.omkar.usermanagement.dto.UserRegistrationRequest;


import dev.omkar.usermanagement.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/register")
public class RegistrationController {

   private final UserService userService;

   @Autowired
   public RegistrationController(UserService userService) {
       this.userService = userService;
   }
   @Operation(summary = "Register a new user")
   @PostMapping
   @ResponseStatus(HttpStatus.CREATED)
   public void registerUser(@RequestBody @Valid UserRegistrationRequest userRegistrationRequest) {
       userService.registerUser(userRegistrationRequest);
   }
}
