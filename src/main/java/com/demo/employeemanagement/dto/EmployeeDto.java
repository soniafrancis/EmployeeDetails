package com.demo.employeemanagement.dto;

public class EmployeeDto {
	
	private Long  empId;
	private String empName;
	private String empemail;
	private String empAge;
	private String empAddress;
	private String empGender;
	
	
	public EmployeeDto(Long empId,String empName, String empemail, String empAge, String empAddress, String empGender) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.empemail = empemail;
		this.empAge = empAge;
		this.empAddress = empAddress;
		this.empGender = empGender;
	}
	
	public EmployeeDto() {
		super();
		
	}

	
	public Long getEmpId() {
		return empId;
	}

	public void setEmpId(Long empId) {
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


	
}
