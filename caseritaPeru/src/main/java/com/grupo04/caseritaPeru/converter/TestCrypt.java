package com.grupo04.caseritaPeru.converter;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class TestCrypt {

	public static void main(String[] args) {
		BCryptPasswordEncoder bc = new BCryptPasswordEncoder();

		System.out.println(bc.encode("1234"));
	}

}
