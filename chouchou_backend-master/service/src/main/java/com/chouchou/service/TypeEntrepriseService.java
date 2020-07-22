package com.chouchou.service;

import java.util.List;
import java.util.Optional;

import com.chouchou.model.TypeEntreprise;

public interface TypeEntrepriseService {
	public TypeEntreprise savOrUpdate(TypeEntreprise o);
	public void delete(Long id);
	public List<TypeEntreprise> findAll();
	public Optional<TypeEntreprise> findByID(long id);

}
