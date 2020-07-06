package com.chouchou.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chouchou.dao.RoleRepository;
import com.chouchou.model.Role;
import com.chouchou.service.RoleService;


@Service
public class RoleServiceImp implements RoleService {

	@Autowired
	RoleRepository roleRepo;
	
	
	@Override
	public List<Role> getAll() {
		return roleRepo.findAll();
	}

	@Override
	public void deleteById(Long id) {
		roleRepo.deleteById(id);		
	}

	@Override
	public Role saveOrUpdate(Role l) {
		return roleRepo.save(l);
	}

}
