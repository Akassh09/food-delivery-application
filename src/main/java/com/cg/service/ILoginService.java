package com.cg.service;

import org.springframework.stereotype.Service;

import com.cg.model.Login;

@Service
public interface ILoginService {
	public  Login signin(Login login);
	public  Login signOut(Login login);

}