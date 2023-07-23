package com.example.demo.Repository;

import com.example.demo.Entitiys.User;

import java.util.List;

public interface UserRepository {
    List<User> getAll();
    void save(User user);
    void deleteAll();
}
