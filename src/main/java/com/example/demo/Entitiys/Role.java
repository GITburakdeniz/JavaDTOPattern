package com.example.demo.Entitiys;

import lombok.Data;

import java.util.Objects;

@Data
public class Role {
    private String id;
    private String name;

    public Role(String name) {
        this.name = Objects.requireNonNull(name);
    }
}
