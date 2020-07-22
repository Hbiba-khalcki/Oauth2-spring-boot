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

import com.chouchou.model.Rating;
import com.chouchou.service.AvisService;

@RestController
@RequestMapping("/avis")
public class AvisController {

		
		@Autowired
		AvisService _serv ;
		
		@RequestMapping(value="/All", method=RequestMethod.GET)
		public List<Rating> findAll()
		{
			return _serv.findAll();
		}
		
		
		
		@RequestMapping(value="/findByID/{id}", method=RequestMethod.GET)
		public Optional<Rating> findByID(@PathVariable Long id)
		{
			
			return _serv.findByID(id);
		}
		
		
		@RequestMapping(value = "/savOrUpdate", method = RequestMethod.POST)
		@ResponseBody
		public String savOrUpdate(@RequestBody Rating o)
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