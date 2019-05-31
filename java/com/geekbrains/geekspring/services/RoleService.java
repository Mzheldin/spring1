package com.geekbrains.geekspring.services;

import com.geekbrains.geekspring.entities.Role;
import com.geekbrains.geekspring.repositories.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService {

    private RoleRepository roleRepository;

    @Autowired
    public void setRoleRepository(RoleRepository roleRepository){
        this.roleRepository = roleRepository;
    }

    public Role findRoleByName(String rolename){
        return roleRepository.findOneByName(rolename);
    }

    public List<Role> findAllRoles(){
        return (List<Role>) roleRepository.findAll();
    }

    public Role findRoleById(Long roleId){
        return roleRepository.findOneById(roleId);
    }

}
