package com.cg.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.cg.dao.LoginRepository;
import com.cg.model.Login;
import com.cg.service.ILoginService;

public class LoginService implements ILoginService {
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
