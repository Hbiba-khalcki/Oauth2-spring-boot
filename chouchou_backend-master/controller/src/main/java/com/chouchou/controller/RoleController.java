package com.chouchou.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.chouchou.model.Role;
import com.chouchou.service.RoleService;



@RestController
@CrossOrigin
@RequestMapping("/role")
public class RoleController {
	
	@Autowired
	RoleService roleService;
	
	@RequestMapping(value="/Allrole", method=RequestMethod.GET)
	public List<Role> findAllRoles()
	{
		return roleService.getAll();
	}
	
	
	@RequestMapping(value = "/addRole", method = RequestMethod.POST)
	@ResponseBody
	public String addRole(@RequestBody Role role)
	{
		if (role != null) {
			roleService.saveOrUpdate(role);
			return "{\"status\":\"success\"}";
		} else 
			return "{\"status\":\"error\"}";
	}
	
	
	
	@RequestMapping(value = "/deleteRole/{id}", method = RequestMethod.DELETE)
	@ResponseBody
	public String deleteRole(@PathVariable Long id) {
		if (id != null) {
			roleService.deleteById(id);
			return "{\"status\":\"success\"}";
		} else 
			return "{\"status\":\"error\"}";
	}
	
//	@RequestMapping(value = "/getRoleById/{id}", method = RequestMethod.GET)
//	public Role getRoleById(@PathVariable Long id) {
//		if (id != null) {
//			return roleService.findRoleByID(id);
//		} else 
//			return null;
//	}
//	
//	@RequestMapping(value = "/getRoleByName/{name}", method = RequestMethod.GET)
//	public Role getRoleById(@PathVariable String name) {
//		if (name != null) {
//			return roleService.findRoleByName(name);
//		} else 
//			return null;
//		
//	}
//	
	

}