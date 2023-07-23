package com.example.demo.Mappers;

import com.example.demo.DTOs.UserCreationDTO;
import com.example.demo.DTOs.UserDTO;
import com.example.demo.Entitiys.User;
import com.example.demo.Entitiys.Role;
import org.springframework.stereotype.Component;

import static java.util.stream.Collectors.toList;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserMapper {
    public UserDTO toDto(User user) {
        String name = user.getName();
        List<String> roles = user
                .getRoles()
                .stream()
                .map(Role::getName)
                .collect(toList());

        return new UserDTO(name, roles);
    }

    public User toUser(UserCreationDTO userDTO) {
        return new User(userDTO.getName(), userDTO.getPassword(), new ArrayList<>());
    }
}
