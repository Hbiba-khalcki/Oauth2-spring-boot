package com.chouchou.service.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chouchou.dao.FournisseurRepository;
import com.chouchou.model.Fournisseur;
import com.chouchou.service.FournisseurService;

@Service
public class FournisseurServiceImp implements FournisseurService {

	@Autowired
	FournisseurRepository rep;

	@Override
	public Fournisseur savOrUpdate(Fournisseur o) {
		return rep.save(o);
	}

	@Override
	public void delete(Long id) {
		rep.deleteById(id);
	}

	@Override
	public List<Fournisseur> findAll() {
		return rep.findAll();
	}

	@Override
	public Optional<Fournisseur> findByID(long id) {
		return rep.findById(id);
	}
}
