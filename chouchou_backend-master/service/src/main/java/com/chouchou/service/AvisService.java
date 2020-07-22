package com.chouchou.service;

import java.util.List;
import java.util.Optional;

import com.chouchou.model.Rating;

public interface AvisService {
	public Rating savOrUpdate(Rating o);
	public void delete(Long id);
	public List<Rating> findAll();
	public Optional<Rating> findByID(long id);
}
