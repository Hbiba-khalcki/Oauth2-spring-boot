package com.chouchou.service.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.chouchou.dao.ServiceRepository;
import com.chouchou.model.Categorie;
import com.chouchou.model.Salon;
import com.chouchou.model.Service;
import com.chouchou.service.ServService;

@org.springframework.stereotype.Service
public class ServServiceImp implements ServService{

	
	@Autowired
	ServiceRepository rep;

	@Override
	public Service savOrUpdate(Service o) {
		return rep.save(o);
	}

	@Override
	public void delete(Long id) {
		rep.deleteById(id);
	}

	@Override
	public List<Service> findAll() {
		return rep.findAll();
	}

	@Override
	public Optional<Service> findByID(long id) {
		return rep.findById(id);
	}

	@Override
	public List<Service> findServiceBySalon(Salon salon) {
		return rep.findServiceBySalon(salon);
	}

//	@Override
//	public List<Categorie> findAllServedCategorie(String login) {
//		System.out.println(rep.findAllServedCategorie(login));
//		return rep.findAllServedCategorie(login);
//	}
}