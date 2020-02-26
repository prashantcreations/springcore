package com.practical.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.practical.spring.driver.DatabaseDrivers;

@Service
public class UserService {
	
	@Autowired
	@Qualifier("oracleDriver")
	DatabaseDrivers dataBaseDriver;
	
	public String getDriverInfo() {
		return dataBaseDriver.getInfo();
	}

}
