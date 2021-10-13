package com.demo.employeemanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.server.ResponseStatusException;


import com.demo.employeemanagement.dto.EmployeeDto;
import com.demo.employeemanagement.exception.EmployeeNotFound;
import com.demo.employeemanagement.service.EmployeeService;



@RestController
@RequestMapping("employee")
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping("/all")
	public ResponseEntity<List<EmployeeDto>> getAll() {
		return ResponseEntity.ok(employeeService.getAll());
	}
	
	@PostMapping("/new")
	public ResponseEntity<EmployeeDto> createNew(@RequestBody EmployeeDto e) {
		return ResponseEntity.ok(employeeService.save(e));
	}
	
	@GetMapping("/{empId}")
	public ResponseEntity<EmployeeDto> findById(@PathVariable Long empId) {
		try {
		//return ResponseEntity.ok(employeeService.getById(empId));
			return new ResponseEntity<EmployeeDto>(this.employeeService.getById(empId),HttpStatus.OK);
	}catch(EmployeeNotFound excp ) {
		 throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Not Here");
	}
	}

	@PutMapping("/{empId}")
	public ResponseEntity<EmployeeDto> updateEmployee(@PathVariable("empId")Long empId,@RequestBody EmployeeDto employee){
		return new ResponseEntity<EmployeeDto>(employeeService.updateEmployee(employee, empId),HttpStatus.OK);
		}
		

	
	@DeleteMapping("/{empId}")
	public ResponseEntity<String> delete(@PathVariable Long empId) {
		this.employeeService.deleteById(empId);
		return new ResponseEntity<String>("Successfully Deleted",HttpStatus.OK);
	}

}
