package com.chouchou.service;

import java.util.List;
import java.util.Optional;

import com.chouchou.model.Marque;

public interface MarqueService {
	public Marque savOrUpdate(Marque o);
	public void delete(Long id);
	public List<Marque> findAll();
	public Optional<Marque> findByID(long id);
}
