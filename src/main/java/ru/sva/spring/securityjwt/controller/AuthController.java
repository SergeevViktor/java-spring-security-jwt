package ru.sva.spring.securityjwt.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.sva.spring.securityjwt.dto.JwtRequest;
import ru.sva.spring.securityjwt.dto.RegistrationUserDto;
import ru.sva.spring.securityjwt.service.AuthService;
import ru.sva.spring.securityjwt.service.UserService;

@RestController
@RequiredArgsConstructor
public class AuthController {
    private final UserService userService;
    private final AuthService authService;

    @PostMapping("/authorization")
    public ResponseEntity<?> createAuthToken(@RequestBody JwtRequest authRequest) {
        return ResponseEntity.ok(authService.createAuthToken(authRequest));
    }

    @PostMapping("/registration")
    public ResponseEntity<?> createUser(@RequestBody RegistrationUserDto registrationUserDto) {
        return ResponseEntity.ok(userService.createUser(registrationUserDto));
    }
}
