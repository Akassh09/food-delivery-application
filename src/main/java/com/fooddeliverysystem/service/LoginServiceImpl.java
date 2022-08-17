package com.fooddeliverysystem.service;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;

import com.fooddeliverysystem.dao.LoginRepository;
import com.fooddeliverysystem.model.Login;
import com.fooddeliverysystem.service.LoginService;

public class LoginServiceImpl implements LoginService {
	@Autowired
	private LoginRepository loginRepository;
	

	public Login addLogin(@Valid Login login) {
		// TODO Auto-generated method stub
		return loginRepository.save(login);
	}


	@Override
	public Login signin(Login login) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Login signOut(Login login) {
		// TODO Auto-generated method stub
		return null;
	}

}
