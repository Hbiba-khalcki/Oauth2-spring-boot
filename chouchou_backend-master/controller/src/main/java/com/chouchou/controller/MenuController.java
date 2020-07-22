package com.chouchou.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.chouchou.model.Menu;
import com.chouchou.service.MenuService;
import com.chouchou.service.RoleService;

@RestController
@RequestMapping("/menu")
public class MenuController {
	
	@Autowired
	MenuService menuService ;
	
	@Autowired 
	RoleService roleService;
	
	@RequestMapping(value="/Allmenu", method=RequestMethod.GET)
	public List<Menu> findAllMenu()
	{
		return menuService.findAll();
	}
	
	
	
	@RequestMapping(value="/AllmenuByIdRole/{roleName}", method=RequestMethod.GET)
	public Menu[]  findAllMenuByIdRole(@PathVariable String roleName)
	{
		
		return menuService.findByIdROLE(roleService.getByName(roleName).getId());
	}
	
	
	@RequestMapping(value = "/addMenu", method = RequestMethod.POST)
	@ResponseBody
	public String addMenu(@RequestBody Menu menu)
	{
		if (menu != null) {
			 menuService.savOrUpdate(menu);
			return "{\"status\":\"success\"}";
		} else 
			return "{\"status\":\"error\"}";
	}
	
	
	
	@RequestMapping(value = "/deleteMenu/{id}", method = RequestMethod.DELETE)
	@ResponseBody
	public String deleteMenu(@PathVariable Long id) {
		if (id != null) {
			menuService.delete(id);	
			return "{\"status\":\"success\"}";
		} else 
			return "{\"status\":\"error\"}";
	}
	

}