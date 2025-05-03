package com.recetabbb.mapper;

import com.recetabbb.dto.ResponseUserDto;
import com.recetabbb.model.User;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author carlossalazar
 **/
@Component
public class UserMapper {

    public ResponseEntity<ResponseUserDto> toResEntity(User user) {
        ResponseUserDto responseUserDto = new ResponseUserDto();
        responseUserDto.setEmail(user.getEmail());
        return ResponseEntity.ok(responseUserDto);
    }

    public List<ResponseEntity<ResponseUserDto>> toResEntity(List<User> users) {
        return users.stream().map(this::toResEntity).collect(Collectors.toList());
    }
}
