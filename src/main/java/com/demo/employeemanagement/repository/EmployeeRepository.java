package com.demo.employeemanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.employeemanagement.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
