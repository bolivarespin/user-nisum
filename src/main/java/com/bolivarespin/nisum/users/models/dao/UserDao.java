package com.bolivarespin.nisum.users.models.dao;

import java.util.UUID;

import org.springframework.data.repository.CrudRepository;

import com.bolivarespin.nisum.users.models.entity.User;

public interface UserDao extends CrudRepository<User, UUID>{

	public User findByEmail(String email);
}