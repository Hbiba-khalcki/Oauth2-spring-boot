package com.chouchou.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.chouchou.model.Marque;
import com.chouchou.service.MarqueService;

@RestController
@RequestMapping("/marques")
public class MarqueController {

		
		@Autowired
		MarqueService _serv ;
		
		@GetMapping
		public List<Marque> findAll(){
			return _serv.findAll();
		}
		
		@GetMapping("/All")
		public List<Marque> findAllid(){
			return _serv.findAll();
		}
		
	    @PostMapping
		@ResponseBody
		public String savOrUpdate(@RequestBody Marque o){
			if (o != null) {
				_serv.savOrUpdate(o);
				return "{\"status\":\"success\"}";
			} else 
				return "{\"status\":\"error\"}";
		}
		
	    @GetMapping("/findByID/{id}")  
		public Optional<Marque> findByID(@PathVariable Long id)	{
			return _serv.findByID(id);
		}
		
 
		
 		@DeleteMapping("/delete/{id}")
		@ResponseBody
		public String delete(@PathVariable Long id) {
			if (id != null) {
				_serv.delete(id);	
				return "{\"status\":\"success\"}";
			} else 
				return "{\"status\":\"error\"}";
		}
		

	}