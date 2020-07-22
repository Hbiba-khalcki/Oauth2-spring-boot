package com.chouchou.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chouchou.dao.MenuRepository;
import com.chouchou.model.Menu;
import com.chouchou.service.MenuService;

import java.util.Optional;

@Service
public class MenuServiceImp implements MenuService{
	
	
	@Autowired
	MenuRepository menuRepository;

	@Override
	public Menu savOrUpdate(Menu menu) {
		return menuRepository.save(menu);
	}

	@Override
	public void delete(Long id) {
		menuRepository.deleteById(id);
		
	}

	@Override
	public List<Menu> findAll() {
		return menuRepository.findAll();
	}

	@Override
	public Optional<Menu> findByID(long id) {
		return menuRepository.findById(id);
	}

	@Override
	public Menu[] findByIdROLE(long id) {
		return menuRepository.findFirstByIdRole(id);
	}

}
