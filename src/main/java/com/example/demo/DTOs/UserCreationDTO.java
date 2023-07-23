package com.example.demo.DTOs;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
public class UserCreationDTO {

    private String name;
    private String password;
    private List<String> roles;
}
