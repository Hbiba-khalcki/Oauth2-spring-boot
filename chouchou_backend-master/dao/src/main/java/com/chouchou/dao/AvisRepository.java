package com.chouchou.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.chouchou.model.Rating;

@Repository
public interface AvisRepository extends JpaRepository<Rating, Long> {

}
