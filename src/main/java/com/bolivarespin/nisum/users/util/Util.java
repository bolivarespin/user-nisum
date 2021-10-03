package com.bolivarespin.nisum.users.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Util {
	public static boolean validateEmail(String email) {
		Pattern pattern = Pattern.compile("([a-z0-9]+(\\.?[a-z0-9])*)+@(([a-z]+)\\.([a-z]{2,}))+");
		Matcher matcher = pattern.matcher(email);
		if (matcher.find() == true)
			return true;
		else
			return false;
	}
	
	public static boolean validatePassword(String password) {
		Pattern pattern = Pattern.compile("(?=.*[0-9].*[0-9])(?=\\w*[A-Z])(?=\\w*[a-z])\\S{8,16}");
		Matcher matcher = pattern.matcher(password);
		if (matcher.find() == true)
			return true;
		else
			return false;
	}
}
