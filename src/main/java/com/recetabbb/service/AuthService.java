package com.recetabbb.service;

import com.recetabbb.dto.LoginRequestDto;
import com.recetabbb.dto.LoginResponseDto;
import com.recetabbb.model.User;
import com.recetabbb.security.JwtUtil;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

/**
 * @author carlossalazar
 **/
@Service
public class AuthService {

    private final UserService userService;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;

    public AuthService(UserService userService, PasswordEncoder passwordEncoder, JwtUtil jwtUtil) {
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
        this.jwtUtil = jwtUtil;
    }

    public LoginResponseDto login(LoginRequestDto loginRequestDto) {
        User user = userService.findByEmail(loginRequestDto.getEmail());
        if (!passwordEncoder.matches(loginRequestDto.getPassword(), user.getPassword())) {
            throw new HttpClientErrorException(HttpStatus.UNAUTHORIZED);
        }
        String token = jwtUtil.generateToken(user.getEmail());
        return new LoginResponseDto(token);
    }
}
