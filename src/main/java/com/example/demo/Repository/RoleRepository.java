package com.example.demo.Repository;

import com.example.demo.Entitiys.Role;

public interface RoleRepository {
    Role getRoleById(String id);
    Role getRoleByName(String name);
    void save(Role role);
}
