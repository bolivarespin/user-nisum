package com.bolivarespin.nisum.users.models.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bolivarespin.nisum.users.models.dao.UserDao;
import com.bolivarespin.nisum.users.models.entity.User;

@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	private UserDao userDao;

	@Override
	@Transactional(readOnly = true)
	public List<User> findAll() {
		return (List<User>) userDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public User findById(UUID id) {
		return userDao.findById(id).orElse(null);
	}

	@Override
	@Transactional(readOnly = true)
	public User findByEmail(String email) {
		return userDao.findByEmail(email);
	}	
	
	@Override
	public void storeUser(User user) {
		userDao.save(user);
	}


}
