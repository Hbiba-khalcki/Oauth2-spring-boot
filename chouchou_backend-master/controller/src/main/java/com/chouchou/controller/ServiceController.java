package com.chouchou.controller;

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
import com.chouchou.service.ServService;

@RestController
@RequestMapping("/service")
public class ServiceController {

		
		@Autowired
		ServService _serv ;
		
		@RequestMapping(value="/All", method=RequestMethod.GET)
		public List<Service> findAll()
		{
			return _serv.findAll();
		}
		
//		@RequestMapping(value="/AllServedCategories/{login}", method=RequestMethod.GET)
//		public List<Categorie> findAllServedCategorie(@PathVariable String login)
//		{
//			return _serv.findAllServedCategorie(login);
//		}
		
		
		
		@RequestMapping(value="/findByID/{id}", method=RequestMethod.GET)
		public Optional<Service> findByID(@PathVariable Long id)
		{
			
			return _serv.findByID(id);
		}
		
		
		@RequestMapping(value = "/savOrUpdate", method = RequestMethod.POST)
		@ResponseBody
		public String e(@RequestBody Service o)
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
		

	}