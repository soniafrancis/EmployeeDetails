package com.demo.employeemanagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.demo.employeemanagement.dto.EmployeeDto;
import com.demo.employeemanagement.service.EmployeeService;



@SpringBootApplication
public class EmployeeDetailsApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeDetailsApplication.class, args);
	}
	@Autowired
	private EmployeeService employeeService;
		@Bean
		public CommandLineRunner initDB()
		{
			return (args) -> {
				this.employeeService.save(new EmployeeDto(1L,"john","john@gmail.com","23","ernakulam","Male"));
				this.employeeService.save(new EmployeeDto(2L,"jeo","joe@gmail.com","24","Thrissur","Male"));
			};
	}
}
