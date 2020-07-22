package com.chouchou.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chouchou.dao.RoleRepository;
import com.chouchou.dao.UserRepository;
import com.chouchou.model.Categorie;
import com.chouchou.model.UserManager;
import com.chouchou.service.UserService;

@Service
public class UserServiceImp implements UserService {
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	RoleRepository roleRepository;

	@Override
	public UserManager findByLogin(String login) {
		return userRepository.findByLogin(login);
	}

	@Override
	public List<UserManager> findALL() {
		return userRepository.findAll();
	}

	@Override
	public UserManager savOrUpdate(UserManager u) {
		return userRepository.save(u);
	}

	@Override
	public void deleteById(long id) {

		userRepository.deleteById((long) id);
	}

	@Override
	public List<UserManager> findAllByRole(String role) {
		return userRepository.findAllByRole(role);
	}

	
	

}
