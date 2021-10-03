package com.bolivarespin.nisum.users;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.bolivarespin.nisum.users.util.Util;

class UtilTest {

	@Test
	void testValidEmail() {
		String email = "juan.perez@mail.com";
		boolean hope = Util.validateEmail(email);
		boolean current = true; 
		assertEquals(hope, current);
	}

	@Test
	void testInvalidEmail() {
		String email = "juan.perez@mail";
		boolean hope = Util.validateEmail(email);
		boolean current = false; 
		assertEquals(hope, current);
	}
	
	@Test
	void testValidPassword() {
		String password = "Hummer77";
		boolean hope = Util.validatePassword(password);
		boolean current = true; 
		assertEquals(hope, current);
	}
	
	@Test
	void testInvalidPassword() {
		String password = "hummer77";
		boolean hope = Util.validatePassword(password);
		boolean current = false; 
		assertEquals(hope, current);
	}
	
	
}
