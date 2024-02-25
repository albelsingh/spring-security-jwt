package com.javatechnophile.jwt.api.service;

import com.javatechnophile.jwt.api.dto.EmployeeRequest;
import com.javatechnophile.jwt.api.entity.Employee;

import java.util.List;

public interface EmployeeService {
    public Employee saveEmployee(EmployeeRequest employeeRequest);
    public List<Employee> getAllEmployees ();
    public Employee getEmployee(int id);
}
