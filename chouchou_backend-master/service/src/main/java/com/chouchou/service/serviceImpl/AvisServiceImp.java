package com.chouchou.service.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chouchou.dao.AvisRepository;
import com.chouchou.model.Rating;
import com.chouchou.service.AvisService;

@Service
public class AvisServiceImp implements AvisService {
	
	
	@Autowired
	AvisRepository rep;

	@Override
	public Rating savOrUpdate(Rating o) {
		return rep.save(o);
	}

	@Override
	public void delete(Long id) {
		rep.deleteById(id);
	}

	@Override
	public List<Rating> findAll() {
		return rep.findAll();
	}

	@Override
	public Optional<Rating> findByID(long id) {
		return rep.findById(id);
	}

}
