package com.chouchou.service;

import java.util.List;

import com.chouchou.model.Role;

public interface RoleService {
	public List<Role> getAll();
	public void deleteById(Long id);
	public Role saveOrUpdate(Role l);
	public Role getByName(String name);

}
