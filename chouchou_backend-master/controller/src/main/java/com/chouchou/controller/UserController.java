package com.chouchou.controller;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.chouchou.model.UserManager;
import com.chouchou.service.UserService;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("users")
public class UserController {

	@Autowired
	UserService userService;

	@RequestMapping(value = "/users", method = RequestMethod.GET)
	public List<UserManager> findAllUsers() {
		return userService.findALL();
	}
	
	@RequestMapping(value = "/all_by_role/{role}", method = RequestMethod.GET)
	public List<UserManager> findAllByRole(@PathVariable String role) {
		return userService.findAllByRole(role);
	}

	private static int workload = 10;

	public static String hashPassword(String password_plaintext) {
		String salt = BCrypt.gensalt(workload);
		String hashed_password = BCrypt.hashpw(password_plaintext, salt);
		return (hashed_password);
	}

	@RequestMapping(value = "/addUser", method = RequestMethod.POST)
	public void addUser(@RequestBody String obj) throws JsonParseException, JsonMappingException, IOException {
		{
			ObjectMapper mapper = new ObjectMapper();
			UserManager user = mapper.readValue(obj.toString(), UserManager.class);
			if (user.getPassword().equals("")) {
				String pass = userService.findByLogin(user.getLogin()).getPassword();
				user.setPassword(pass);
				userService.savOrUpdate(user);
			} else {
				user.setPassword(hashPassword(user.getPassword()));
				userService.savOrUpdate(user);

			}

		}
	}

	@RequestMapping(value = "/deleteUser/{id}", method = RequestMethod.DELETE)
	@ResponseBody
	public String deleteUser(@PathVariable Long id) {
		if (id != null) {
			userService.deleteById(id);
			return "{\"status\":\"supprimé avec succès\"}";
		} else
			return "{\"status\":\"error\"}";
	}

	@RequestMapping(value = "/findByLogin/{login}", method = RequestMethod.GET)
	public UserManager getByLogin(@PathVariable String login) {
		return userService.findByLogin(login);
	}

}