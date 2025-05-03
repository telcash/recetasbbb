package com.recetabbb.controller;

import com.recetabbb.dto.CreateUserDto;
import com.recetabbb.dto.ResponseUserDto;
import com.recetabbb.mapper.UserMapper;
import com.recetabbb.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author carlossalazar
 **/
@RestController
@RequestMapping("/api/users")
public class UserController {
    private final UserService userService;
    private final UserMapper userMapper;

    public UserController(UserService userService, UserMapper userMapper) {
        this.userService = userService;
        this.userMapper = userMapper;
    }

    @PostMapping
    public ResponseEntity<ResponseUserDto> createUser(@Valid @RequestBody CreateUserDto dto) {
        return this.userMapper.toResEntity(this.userService.createUser(dto));
    }
}
