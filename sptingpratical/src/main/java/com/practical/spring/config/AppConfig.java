package com.practical.spring.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import com.practical.spring.driver.DatabaseDrivers;
import com.practical.spring.driver.MySqlDriver;
import com.practical.spring.driver.OracleDriver;

@Configuration
@ComponentScan("com.practical.spring")
@PropertySource("classpath:oracledatabase.properties")
public class AppConfig {
	
	@Autowired
	Environment enviroment;
	
	@Bean
	DatabaseDrivers oracleDriver() {// this method name should be as name of bean
		OracleDriver oracleDriver = new OracleDriver();
		oracleDriver.setDriver(enviroment.getProperty("db.driver"));
		oracleDriver.setPassword(enviroment.getProperty("db.password"));
		oracleDriver.setPort(Integer.parseInt(enviroment.getProperty("db.port")));
		oracleDriver.setUrl(enviroment.getProperty("db.url"));
		oracleDriver.setUser(enviroment.getProperty("db.user"));
		
		return oracleDriver;// this is refrence of bean which we will for autowire
	}
	@Bean
	DatabaseDrivers mySqlDriver() {
		return new MySqlDriver();
	}
	

}
