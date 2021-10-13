package com.demo.employeemanagement.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.demo.employeemanagement.dto.EmployeeDto;
import com.demo.employeemanagement.exception.EmployeeNotFound;
import com.demo.employeemanagement.repository.EmployeeRepository;
import com.demo.employeemanagement.util.EmployeeEntityDtoUtil;


@Component
public class EmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	public List<EmployeeDto> getAll() {
		return employeeRepository.findAll().stream().map(EmployeeEntityDtoUtil::entityToDto).collect(Collectors.toList());
	}
	
	public EmployeeDto getById(Long empId) {
		//return employeeRepository.findById(empId).map(EmployeeEntityDtoUtil::entityToDto).orElse(null);
	Optional<EmployeeDto> optionalEmployee = Optional.ofNullable(employeeRepository.findById(empId).map(EmployeeEntityDtoUtil::entityToDto).orElse(null));	
	
	return optionalEmployee.orElseThrow(() ->
		new EmployeeNotFound("Not Found in Directory"+empId));
	}
	
	public void deleteById(Long empId) {
		//employeeRepository.deleteById(empId);
		employeeRepository.findById(empId).orElseThrow(
				() ->new EmployeeNotFound("Check the input" +empId));
		employeeRepository.deleteById(empId);
	}


	public EmployeeDto save(EmployeeDto e) {
		return EmployeeEntityDtoUtil.entityToDto(employeeRepository.save(EmployeeEntityDtoUtil.dtoToEntity(e)));
	}

	
	   public EmployeeDto updateEmployee(EmployeeDto newEmployee, Long empId) {
	        //return employeeRepository.save(employee) ;
	        //return employeeService.findByEmployeeId(id)
	        return employeeRepository.findById(empId)
	                .map(employees -> {
	                    employees.setEmpId(newEmployee.getEmpId());
	                    employees.setEmpName(newEmployee.getEmpName());
	                    employees.setEmpemail(newEmployee.getEmpemail());
	                    employees.setEmpAddress(newEmployee.getEmpAddress());
	                    employees.setEmpAge(newEmployee.getEmpAge());
	                    employees.setEmpGender(newEmployee.getEmpGender());
	                    //employees.setNumber(newEmployee.getNumber());
	                   // employees.setLocation(newEmployee.getLocation());
	                    return employeeRepository.save(employees);
	                })
	                .orElseGet(() -> {
	                    newEmployee.setEmpId(empId);
	                    return employeeRepository.save(EmployeeEntityDtoUtil.dtoToEntity(newEmployee));
	                });
	    }
	

}
