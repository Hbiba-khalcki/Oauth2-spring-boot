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

import com.chouchou.model.Salon;
import com.chouchou.model.UserManager;
import com.chouchou.service.SalonService;
import com.chouchou.service.UserService;

@RestController
@RequestMapping("/salon")
public class SalonController {

		
		@Autowired
		SalonService _serv ;
		
		@Autowired
		UserService userService;
		
		@Autowired
		SalonService salonService;
		
		
		@RequestMapping(value="/All", method=RequestMethod.GET)
		public List<Salon> findAll()
		{
			return _serv.findAll();
		}
		
		@RequestMapping(value="/AllStaff/{login}", method=RequestMethod.GET)
		public List<UserManager> findAllStaff(@PathVariable String login)
		{
			UserManager u = userService.findByLogin(login);
			Salon s = u.getSalon();
			return s.getStaff();
		}
		
		
		
		@RequestMapping(value="/findByID/{id}", method=RequestMethod.GET)
		public Optional<Salon> findByID(@PathVariable Long id)
		{
			
			return _serv.findByID(id);
		}
		
		
		@RequestMapping(value = "/savOrUpdate", method = RequestMethod.POST)
		@ResponseBody
		public String savOrUpdate(@RequestBody Salon o)
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