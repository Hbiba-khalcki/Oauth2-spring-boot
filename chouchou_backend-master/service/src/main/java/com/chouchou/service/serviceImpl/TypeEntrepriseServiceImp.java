package com.chouchou.service.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chouchou.dao.TypeEntrepriseRepository;
import com.chouchou.model.TypeEntreprise;
import com.chouchou.service.TypeEntrepriseService;

@Service
public class TypeEntrepriseServiceImp implements TypeEntrepriseService{


	@Autowired
	TypeEntrepriseRepository rep;

	@Override
	public TypeEntreprise savOrUpdate(TypeEntreprise o) {
		return rep.save(o);
	}

	@Override
	public void delete(Long id) {
		rep.deleteById(id);
	}

	@Override
	public List<TypeEntreprise> findAll() {
		return rep.findAll();
	}

	@Override
	public Optional<TypeEntreprise> findByID(long id) {
		return rep.findById(id);
	}
}