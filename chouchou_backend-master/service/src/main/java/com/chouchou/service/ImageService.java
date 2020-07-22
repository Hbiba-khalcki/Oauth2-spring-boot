package com.chouchou.service;

import java.util.List;
import java.util.Optional;

import com.chouchou.model.Image;

public interface ImageService {
	public Image savOrUpdate(Image o);
	public void delete(Long id);
	public List<Image> findAll();
	public Optional<Image> findByID(long id);
}
