package com.chouchou.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.chouchou.model.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long>{
    public Role findByNomRole(String NomRole);
}
