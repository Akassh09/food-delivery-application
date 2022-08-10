package com.cg.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.cg.dao.LoginRepository;
import com.cg.model.Login;
import com.cg.service.LoginServiceImpl;

public class LoginService implements LoginServiceImpl {
	@Autowired
	private LoginRepository loginRepository;
	@Override
	public Login signin(Login login) {
		// TODO Auto-generated method stub
		return loginRepository.save(login);
	}

	@Override
	public Login signOut(Login login) {
		// TODO Auto-generated method stub
		return loginRepository.save(login);
	}

}
