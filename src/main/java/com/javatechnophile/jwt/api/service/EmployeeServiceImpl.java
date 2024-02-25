package com.javatechnophile.jwt.api.service;

import com.javatechnophile.jwt.api.dto.EmployeeRequest;
import com.javatechnophile.jwt.api.entity.Employee;
import com.javatechnophile.jwt.api.exception.UserNotFoundException;
import com.javatechnophile.jwt.api.repository.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    @Autowired
    EmployeeRepo employeeRepo;
    @Override
    public Employee saveEmployee(EmployeeRequest employeeRequest){
        Employee employee=Employee.build(0,employeeRequest.getName(),employeeRequest.getEmail(),employeeRequest.getMobile(),
                employeeRequest.getGender(),employeeRequest.getAge(),employeeRequest.getNationality());
        return employeeRepo.save(employee);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepo.findAll();
    }

    @Override
    public Employee getEmployee(int id) {
        Employee employee= employeeRepo.findByEmployeeId(id);
        if(employee !=null){
            return employee;
        }else{
            throw new UserNotFoundException("User is not found with : "+id);
        }
    }
}
