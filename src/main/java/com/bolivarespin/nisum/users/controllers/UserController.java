package com.bolivarespin.nisum.users.controllers;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bolivarespin.nisum.users.models.entity.User;
import com.bolivarespin.nisum.users.models.service.IUserService;
import com.bolivarespin.nisum.users.util.Util;

@RestController
public class UserController {
	@Autowired
	private IUserService userService;

	@GetMapping("/users")
	public List<User> list() {
		return userService.findAll();
	}

	@GetMapping("/users/{id}")
	public User list(@PathVariable UUID id) {
		return userService.findById(id);
	}

	@PostMapping("/users")
	public String create(@RequestBody User user) {
		User userFinder = userService.findByEmail(user.getEmail());
		boolean validateEmail = Util.validateEmail(user.getEmail());
		boolean validatePassword = Util.validatePassword(user.getPassword());

		if (validateEmail == true) {
			if (validatePassword == true) {
				if (userFinder == null) {
					user.setIsactive(true);
					Date now = new Date();
					user.setCreated(now);
					user.setLastLogin(now);
					UUID token = UUID.randomUUID();
					user.setToken(token.toString());
					userService.storeUser(user);
					
					return "{\"id\":\"" + user.getId().toString() + "\", \"created\": \"" + user.getCreated().toString()
							+ "\", \"modified\":\"" + user.getModified() + "\", \"last_login\":\"" + user.getLastLogin()
							+ "\",\"token\":\"" + user.getToken() + "\",\"isactive\":\"" + user.isIsactive() + "\"}";
				} else {
					return "{\"mensaje\": \"Ya existe el correo\"}";
				}
			} else {
				return "{\"mensaje\": \"Passowrd inválido debe tener: entre 8 y 16 caracteres, de esos 2 deben ser números y al menos 1 letra mayúscula\"}";
			}
		} else {
			return "{\"mensaje\": \"Email invalido\"}";
		}
	}

}
