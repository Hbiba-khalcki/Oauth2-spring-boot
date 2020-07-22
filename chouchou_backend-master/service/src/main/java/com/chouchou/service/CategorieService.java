package com.chouchou.service;

import java.util.List;
import java.util.Optional;

import com.chouchou.model.Categorie;
import com.chouchou.model.UserManager;

public interface CategorieService {
	public Categorie savOrUpdate(Categorie o);
	public void delete(Long id);
	public List<Categorie> findAll();
	public Optional<Categorie> findByID(long id);
}
