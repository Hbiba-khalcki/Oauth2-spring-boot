package com.chouchou.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.chouchou.model.Salon;

@Repository
public interface SalonRepository extends JpaRepository<Salon, Long> {

}
