package com.chouchou.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.chouchou.model.Categorie;
import com.chouchou.model.UserManager;

@Repository
public interface CategorieRepository extends JpaRepository<Categorie, Long>{


}
