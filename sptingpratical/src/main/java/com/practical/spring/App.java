package com.practical.spring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.practical.spring.config.AppConfig;
import com.practical.spring.driver.DatabaseDrivers;
import com.practical.spring.service.UserService;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	AbstractApplicationContext appContext = new AnnotationConfigApplicationContext(AppConfig.class);
    	
    	DatabaseDrivers oracle = appContext.getBean("oracleDriver",DatabaseDrivers.class);
    	DatabaseDrivers mysql  = appContext.getBean("mySqlDriver",DatabaseDrivers.class);
    	
    	System.out.println(oracle.getInfo());
    	System.out.println(mysql.getInfo());
    	
    	UserService userService = appContext.getBean(UserService.class);
    	System.out.println(userService.getDriverInfo());
    	
        
    }
}
