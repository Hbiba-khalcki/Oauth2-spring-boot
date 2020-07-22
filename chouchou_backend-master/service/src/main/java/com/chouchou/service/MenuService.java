package com.chouchou.service;

import java.util.List;
import java.util.Optional;

import com.chouchou.model.Menu;

public interface MenuService {
	
	public Menu savOrUpdate(Menu menu);
	public void delete(Long id);
	public List<Menu> findAll();
	public Optional<Menu> findByID(long id);
	public Menu[] findByIdROLE(long id);

}
