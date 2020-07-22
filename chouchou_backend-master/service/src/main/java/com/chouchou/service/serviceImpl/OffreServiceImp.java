package com.chouchou.service.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chouchou.dao.OffreRepository;
import com.chouchou.model.Offre;
import com.chouchou.service.OffreService;

@Service
public class OffreServiceImp implements OffreService{
	@Autowired
	OffreRepository rep;

	@Override
	public Offre savOrUpdate(Offre o) {
		return rep.save(o);
	}

	@Override
	public void delete(Long id) {
		rep.deleteById(id);
	}

	@Override
	public List<Offre> findAll() {
		return rep.findAll();
	}

	@Override
	public Optional<Offre> findByID(long id) {
		return rep.findById(id);
	}
}