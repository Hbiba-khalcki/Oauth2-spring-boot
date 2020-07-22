package com.chouchou.service;

import java.util.List;
import java.util.Optional;

import com.chouchou.model.Categorie;
import com.chouchou.model.Salon;
import com.chouchou.model.Service;

public interface ServService {
	public Service savOrUpdate(Service o);
	public void delete(Long id);
	public List<Service> findAll();
	public Optional<Service> findByID(long id);
//	public List<Categorie> findAllServedCategorie(String login);
	public List<Service> findServiceBySalon(Salon salon);
}
