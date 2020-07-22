package com.chouchou.service;

import java.util.List;
import java.util.Optional;

import com.chouchou.model.Produit;

public interface ProduitService {
	public Produit savOrUpdate(Produit o);
	public void delete(Long id);
	public List<Produit> findAll();
	public Optional<Produit> findByID(long id);
}
