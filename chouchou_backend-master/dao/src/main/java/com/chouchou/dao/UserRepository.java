package com.chouchou.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.chouchou.model.Categorie;
import com.chouchou.model.UserManager;

@Repository
public interface UserRepository extends JpaRepository<UserManager, Long> {
	
public UserManager findByLogin(String login);

@Query("select u FROM UserManager u INNER JOIN u.roles r WHERE r.id = (select id from Role where nomRole=:x)")
public List<UserManager> findAllByRole(@Param("x") String role);



}
