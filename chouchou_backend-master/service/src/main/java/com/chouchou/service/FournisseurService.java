package com.chouchou.service;

import java.util.List;
import java.util.Optional;

import com.chouchou.model.Fournisseur;

public interface FournisseurService {
	public Fournisseur savOrUpdate(Fournisseur o);
	public void delete(Long id);
	public List<Fournisseur> findAll();
	public Optional<Fournisseur> findByID(long id);
}
