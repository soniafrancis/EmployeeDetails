package com.demo.employeemanagement.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.demo.employeemanagement.dto.EmployeeDto;

@Entity
public class Employee extends EmployeeDto{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long  empId;
	private String empName;
	private String empemail;
	private String empAge;
	private String empAddress;
	private String empGender;
	
	public Employee() {
		
		super();
	}

	public Long getEmpId() {
		return empId;
	}

	public void setId(Long empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getEmpemail() {
		return empemail;
	}

	public void setEmpemail(String empemail) {
		this.empemail = empemail;
	}

	public String getEmpAge() {
		return empAge;
	}

	public void setEmpAge(String empAge) {
		this.empAge = empAge;
	}

	public String getEmpAddress() {
		return empAddress;
	}

	public void setEmpAddress(String empAddress) {
		this.empAddress = empAddress;
	}

	public String getEmpGender() {
		return empGender;
	}

	public void setEmpGender(String empGender) {
		this.empGender = empGender;
	}

	public Employee(Long empId,String empName, String empemail, String empAge, String empAddress, String empGender) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.empemail = empemail;
		this.empAge = empAge;
		this.empAddress = empAddress;
		this.empGender = empGender;
	}
	
	
}

