package com.chouchou.dao;

import com.chouchou.model.UserManager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserManager, Long> {


    UserManager findByEmail(String email);

    Boolean existsByEmail(String email);
}
