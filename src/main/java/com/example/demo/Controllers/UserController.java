package com.example.demo.Controllers;

import com.example.demo.DTOs.UserCreationDTO;
import com.example.demo.DTOs.UserDTO;
import com.example.demo.DTOs.UserIdDTO;
import com.example.demo.Entitiys.User;
import com.example.demo.Mappers.UserMapper;
import com.example.demo.Services.RoleService;
import com.example.demo.Services.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static java.util.stream.Collectors.toList;

@RestController
@RequestMapping("/users")
public class UserController {

    private UserService userService;
    private RoleService roleService;
    private UserMapper mapper;

    public UserController(UserService userService, RoleService roleService, UserMapper mapper) {
        this.userService = userService;
        this.roleService = roleService;
        this.mapper = mapper;
    }

    @GetMapping
    @ResponseBody
    public List<UserDTO> getUsers() {
        return userService.getAll()
                .stream()
                .map(mapper::toDto)
                .collect(toList());
    }


    @PostMapping
    @ResponseBody
    public UserIdDTO create(@RequestBody UserCreationDTO userDTO) {
        User user = mapper.toUser(userDTO);

        userDTO.getRoles()
                .stream()
                .map(role -> roleService.getOrCreate(role))
                .forEach(user::addRole);

        userService.save(user);

        return new UserIdDTO(user.getId());
    }

}
