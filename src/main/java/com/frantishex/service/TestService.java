package com.frantishex.service;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

@Service
@Transactional
public class TestService {

	public String stringReturn(Long value) {
		if (value == 1) {
			return "Good job !";
		} else {
			return "Nice job !";
		}
	}

}
