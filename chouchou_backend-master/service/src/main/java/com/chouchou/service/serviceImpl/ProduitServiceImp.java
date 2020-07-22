package com.chouchou.service.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chouchou.dao.ProduitRepository;
import com.chouchou.model.Produit;
import com.chouchou.service.ProduitService;

@Service
public class ProduitServiceImp implements ProduitService{

	
	@Autowired
	ProduitRepository rep;

	@Override
	public Produit savOrUpdate(Produit o) {
		return rep.save(o);
	}

	@Override
	public void delete(Long id) {
		rep.deleteById(id);
	}

	@Override
	public List<Produit> findAll() {
		return rep.findAll();
	}

	@Override
	public Optional<Produit> findByID(long id) {
		return rep.findById(id);
	}
}