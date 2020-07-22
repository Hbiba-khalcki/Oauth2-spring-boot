package com.chouchou.service;

import java.util.List;
import java.util.Optional;

import com.chouchou.model.Offre;

public interface OffreService {
	public Offre savOrUpdate(Offre o);
	public void delete(Long id);
	public List<Offre> findAll();
	public Optional<Offre> findByID(long id);

}
