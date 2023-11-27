package ru.sva.spring.securityjwt.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import ru.sva.spring.securityjwt.dto.JwtRequest;
import ru.sva.spring.securityjwt.dto.JwtResponse;
import ru.sva.spring.securityjwt.exception.AppError;
import ru.sva.spring.securityjwt.util.JwtTokenUtils;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final UserDetailsServiceImpl userDetailsServiceImpl;
    private final JwtTokenUtils jwtTokenUtils;
    private final AuthenticationManager authenticationManager;

    public JwtResponse createAuthToken(JwtRequest authRequest) {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                    authRequest.getUsername(),
                    authRequest.getPassword()
            ));
        } catch (BadCredentialsException exception) {
            throw new AppError("Некорректный логин/пароль!");
        }
        UserDetails userDetails = userDetailsServiceImpl.loadUserByUsername(authRequest.getUsername());
        String token = jwtTokenUtils.generateToken(userDetails);

        return new JwtResponse(token);
    }
}
