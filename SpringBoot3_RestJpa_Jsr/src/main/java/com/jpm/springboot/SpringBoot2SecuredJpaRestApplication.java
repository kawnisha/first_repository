package com.jpm.springboot;
import java.util.List;

/** @author Smita **/
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.jpm.springboot.entities.Employee;
import com.jpm.springboot.exception.EmployeeException;
import com.jpm.springboot.service.EmployeeService;
import com.jpm.springboot.service.IEmployeeService;
@SpringBootApplication
public class SpringBoot2SecuredJpaRestApplication {
	public static void main(String[] args) throws EmployeeException {
		SpringApplication.run(SpringBoot2SecuredJpaRestApplication.class, args);
		

		
	}
}

