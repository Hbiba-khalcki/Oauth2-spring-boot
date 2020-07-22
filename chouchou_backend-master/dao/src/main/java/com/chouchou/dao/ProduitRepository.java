package com.chouchou.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.chouchou.model.Produit;

@Repository
public interface ProduitRepository extends JpaRepository<Produit, Long>{

}
