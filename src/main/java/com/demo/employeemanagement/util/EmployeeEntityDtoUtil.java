package com.demo.employeemanagement.util;

import com.demo.employeemanagement.dto.EmployeeDto;
import com.demo.employeemanagement.entity.Employee;

public class EmployeeEntityDtoUtil {

    public static EmployeeDto entityToDto(Employee e) {
        return new EmployeeDto(e.getEmpId(),e.getEmpName(),e.getEmpemail(),e.getEmpAge(),e.getEmpAddress(),e.getEmpGender());
    }

    public static Employee dtoToEntity(EmployeeDto e) {
        return new Employee(e.getEmpId(),e.getEmpName(),e.getEmpemail(),e.getEmpAge(),e.getEmpAddress(),e.getEmpGender());
    }

}
