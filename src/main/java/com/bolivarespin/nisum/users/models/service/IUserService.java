package com.bolivarespin.nisum.users.models.service;

import java.util.List;
import java.util.UUID;


import com.bolivarespin.nisum.users.models.entity.User;

public interface IUserService {
	public List<User> findAll();

	public User findById(UUID id);
	
	public void storeUser(User user);
	
	public User findByEmail(String email);
	
}
