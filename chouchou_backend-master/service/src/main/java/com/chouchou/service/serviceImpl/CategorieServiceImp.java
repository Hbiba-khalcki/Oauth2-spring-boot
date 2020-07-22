package com.chouchou.service.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chouchou.dao.CategorieRepository;
import com.chouchou.model.Categorie;
import com.chouchou.model.UserManager;
import com.chouchou.service.CategorieService;

@Service
public class CategorieServiceImp implements CategorieService{
	
	
	@Autowired
	CategorieRepository rep;

	@Override
	public Categorie savOrUpdate(Categorie o) {
		return rep.save(o);
	}

	@Override
	public void delete(Long id) {
		rep.deleteById(id);
	}

	@Override
	public List<Categorie> findAll() {
		return rep.findAll();
	}

	@Override
	public Optional<Categorie> findByID(long id) {
		return rep.findById(id);
	}


}
