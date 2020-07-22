package com.chouchou.service.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chouchou.dao.SalonRepository;
import com.chouchou.model.Salon;
import com.chouchou.model.UserManager;
import com.chouchou.service.SalonService;

@Service
public class SalonServiceImp implements SalonService{
	
	
	@Autowired
	SalonRepository rep;

	@Override
	public Salon savOrUpdate(Salon o) {
		return rep.save(o);
	}

	@Override
	public void delete(Long id) {
		rep.deleteById(id);
	}

	@Override
	public List<Salon> findAll() {
		return rep.findAll();
	}

	@Override
	public Optional<Salon> findByID(long id) {
		return rep.findById(id);
	}


}