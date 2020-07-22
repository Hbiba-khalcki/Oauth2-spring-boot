package com.chouchou.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.chouchou.model.Categorie;
import com.chouchou.model.Service;
import com.chouchou.model.UserManager;
import com.chouchou.service.CategorieService;
import com.chouchou.service.ServService;
import com.chouchou.service.UserService;

@RestController
@RequestMapping("/categorie")
public class CategorieController {

		
		@Autowired
		CategorieService _serv ;
		
		@Autowired
		UserService _servUser ;
		
		@Autowired
		ServService _servService ;
		
		@RequestMapping(value="/All", method=RequestMethod.GET)
		public List<Categorie> findAll()
		{
			return _serv.findAll();
		}
		
		
		
		@RequestMapping(value="/findByID/{id}", method=RequestMethod.GET)
		public Optional<Categorie> findByID(@PathVariable Long id)
		{
			
			return _serv.findByID(id);
		}
		
		
		@RequestMapping(value = "/savOrUpdate", method = RequestMethod.POST)
		@ResponseBody
		public String savOrUpdate(@RequestBody Categorie o)
		{
			if (o != null) {
				_serv.savOrUpdate(o);
				return "{\"status\":\"success\"}";
			} else 
				return "{\"status\":\"error\"}";
		}
		
		
		
		@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
		@ResponseBody
		public String delete(@PathVariable Long id) {
			if (id != null) {
				_serv.delete(id);	
				return "{\"status\":\"success\"}";
			} else 
				return "{\"status\":\"error\"}";
		}
		
		@RequestMapping(value="/AllServedCategories/{login}", method=RequestMethod.GET)
		public List<Categorie> findAllServedCategorie(@PathVariable String login)
		{   
			UserManager u = _servUser.findByLogin(login);
			List<Service> listService = _servService.findServiceBySalon(u.getSalon());
			List<Categorie> listCategorie = new ArrayList<>();
			for(int i=0;i<listService.size();i++)
			{
				listCategorie.add(listService.get(i).getCategorie());
			}
		    return listCategorie;
		}
		
		

	}