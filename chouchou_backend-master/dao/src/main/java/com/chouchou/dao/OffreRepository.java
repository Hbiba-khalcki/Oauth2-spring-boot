package com.chouchou.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.chouchou.model.Offre;

@Repository
public interface OffreRepository extends JpaRepository<Offre, Long>{

}
