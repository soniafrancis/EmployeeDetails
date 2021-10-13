package com.demo.employeemanagement.exception;


@SuppressWarnings("serial")
public class EmployeeNotFound extends RuntimeException{

	public EmployeeNotFound(String message) {
		super(message);
		
	}
	
	
}
