package com.chouchou.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.chouchou.model.TypeEntreprise;

@Repository
public interface TypeEntrepriseRepository extends JpaRepository<TypeEntreprise, Long> {

}
