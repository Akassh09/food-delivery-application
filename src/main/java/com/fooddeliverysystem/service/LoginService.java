package com.fooddeliverysystem.service;

import org.springframework.stereotype.Service;

import com.fooddeliverysystem.model.Login;

@Service
public interface LoginService {
	public  Login signin(Login login);
	public  Login signOut(Login login);

}