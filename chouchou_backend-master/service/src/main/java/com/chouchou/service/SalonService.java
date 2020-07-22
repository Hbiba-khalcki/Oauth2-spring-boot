package com.chouchou.service;

import java.util.List;
import java.util.Optional;

import com.chouchou.model.Salon;
import com.chouchou.model.UserManager;

public interface SalonService {
	public Salon savOrUpdate(Salon o);
	public void delete(Long id);
	public List<Salon> findAll();
	public Optional<Salon> findByID(long id);
	
}
