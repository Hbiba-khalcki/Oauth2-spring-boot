package com.chouchou.service.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chouchou.dao.MarqueRepository;
import com.chouchou.model.Marque;
import com.chouchou.service.MarqueService;

@Service
public class MarqueServiceImp implements MarqueService{
	
	@Autowired
	MarqueRepository rep;

	@Override
	public Marque savOrUpdate(Marque o) {
		return rep.save(o);
	}

	@Override
	public void delete(Long id) {
		rep.deleteById(id);
	}

	@Override
	public List<Marque> findAll() {
		return rep.findAll();
	}

	@Override
	public Optional<Marque> findByID(long id) {
		return rep.findById(id);
	}
}
