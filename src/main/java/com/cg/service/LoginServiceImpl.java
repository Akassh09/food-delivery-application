package com.cg.service;

import org.springframework.stereotype.Service;

import com.cg.model.Login;

@Service
public interface LoginServiceImpl {
	public  Login signin(Login login);
	public  Login signOut(Login login);

}