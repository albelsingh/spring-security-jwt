package com.javatechnophile.jwt.api.controller;

import com.javatechnophile.jwt.api.dto.EmployeeRequest;
import com.javatechnophile.jwt.api.entity.Employee;
import com.javatechnophile.jwt.api.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    @PostMapping("/signup")
    public ResponseEntity<Employee> saveEmployee(@RequestBody @Valid EmployeeRequest request){
        return new ResponseEntity<>(employeeService.saveEmployee(request), HttpStatus.CREATED);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployee(@PathVariable int id){
        return new ResponseEntity<>(employeeService.getEmployee(id), HttpStatus.OK);
    }
    @GetMapping("/getAllEmployee")
    public ResponseEntity<List<Employee>> getAllEmployees(){
        return new ResponseEntity<>(employeeService.getAllEmployees(), HttpStatus.OK);
    }
}
