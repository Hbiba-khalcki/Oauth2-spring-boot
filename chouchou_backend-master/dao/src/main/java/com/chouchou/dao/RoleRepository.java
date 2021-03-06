package com.chouchou.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.chouchou.model.Menu;
import com.chouchou.model.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long>{


	
	@Query("FROM Role r WHERE r.nomRole = :rolename")
    public Role getByName(@Param("rolename") String roleName);

}
