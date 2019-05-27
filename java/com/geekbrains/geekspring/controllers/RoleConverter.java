package com.geekbrains.geekspring.controllers;

import com.geekbrains.geekspring.entities.Role;
import com.geekbrains.geekspring.services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class RoleConverter implements Converter<String, Role> {

    RoleService roleService;

    @Autowired
    public void setRoleService(RoleService roleService) {
        this.roleService = roleService;
    }

    @Override
    public Role convert(String id) {
        return roleService.findRoleById(Long.parseLong(id));
    }
}
